package com.cjbdevlabs.designpatterns.behavioral;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
Decouple sender of a request from the receiver of a request
 */
public class ChainOfResponsibilityPattern {

    static class LoggerRequest {

        private final String message;
        private final LoggerType loggerType;

        public LoggerRequest(String message, LoggerType loggerType) {
            this.message = message;
            this.loggerType = loggerType;
        }

        public String getMessage() {
            return this.message;
        }

        public LoggerType getLoggerType() {
            return this.loggerType;
        }

        public enum LoggerType {
            CONSOLE,
            FILE
        }
    }

    static abstract class Logger {

        public final Logger nextLogger;

        public Logger(Logger nextLogger) {
            this.nextLogger = nextLogger;
        }

        public abstract void log(LoggerRequest request);
    }

    static class ConsoleLogger extends Logger {

        public ConsoleLogger(Logger nextLogger) {
            super(nextLogger);
        }

        @Override
        public void log(LoggerRequest request) {
            if (request.getLoggerType() == LoggerRequest.LoggerType.CONSOLE) {
                System.out.println(request.getMessage());
            } else if (nextLogger != null) {
                nextLogger.log(request);
            }
        }
    }

    static class FileLogger extends Logger {

        public FileLogger(Logger nextLogger) {
            super(nextLogger);
        }

        @Override
        public void log(LoggerRequest request) {
            if (request.getLoggerType() == LoggerRequest.LoggerType.FILE) {
                try {
                    var writer = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true));
                    writer.write(request.getMessage() + "\n");
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (nextLogger != null) {
                nextLogger.log(request);
            }
        }
    }

    static class App {

        public static void main(String[] args) {
            var message = "Hello World";
            var request = new LoggerRequest(message, LoggerRequest.LoggerType.CONSOLE);
            Logger logger = buildChain();
            logger.log(request);
        }

        private static Logger buildChain() {
            var fileLogger = new FileLogger(null);
            var consoleLogger = new ConsoleLogger(fileLogger);
            return consoleLogger;
        }
    }
}
