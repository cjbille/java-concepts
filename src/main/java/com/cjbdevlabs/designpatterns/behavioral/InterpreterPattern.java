package com.cjbdevlabs.designpatterns.behavioral;

/*
Way of translating one language into another
 */
public class InterpreterPattern {

    interface Expression {

        String interpret(String context);

    }

    static class FirstLetterShouldBeLowerCase implements Expression {

        private final NoWhitespace noWhitespace = new NoWhitespace();

        @Override
        public String interpret(String context) {
            context = context.substring(0, 1).toLowerCase() + context.substring(1);
            return noWhitespace.interpret(context);
        }
    }

    static class FirstLetterShouldNotBeUnderscore implements Expression {

        private final FirstLetterShouldBeLowerCase firstLetterShouldBeLowerCase = new FirstLetterShouldBeLowerCase();
        @Override
        public String interpret(String context) {
            if (context.startsWith("_")) {
                context = context.substring(1);
            }
            return firstLetterShouldBeLowerCase.interpret(context);
        }
    }

    static class NoWhitespace implements Expression {

        @Override
        public String interpret(String context) {
            return context.replaceAll(" ", "");
        }

    }
}
