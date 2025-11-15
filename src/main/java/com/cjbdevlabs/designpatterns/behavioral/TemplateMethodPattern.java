package com.cjbdevlabs.designpatterns.behavioral;

/*
The template method pattern is all about defining the common steps in an
algorithm in a superclass, and redefining some of those steps in a subclass.
This is actually one of the most commonly used design patterns
 */
public class TemplateMethodPattern {

    static class App {

        public static void main(String[] args) {
            var welcomeEmail = new WelcomeEmail();
            welcomeEmail.sendGreeting();
            welcomeEmail.sendMessageBody();
            welcomeEmail.sendClosing();

            var unsubscribeEmail = new UnsubscribeEmail();
            unsubscribeEmail.sendGreeting();
            unsubscribeEmail.sendMessageBody();
            unsubscribeEmail.sendClosing();
        }
    }

    static abstract class email {

        public void sendGreeting() {
            System.out.println("Hello,");
        }

        public abstract void sendMessageBody();

        public void sendClosing() {
            System.out.println("Best regards, Sam");
        }
    }

    static class UnsubscribeEmail extends email {

        @Override
        public void sendMessageBody() {
            System.out.println("We are sorry to see you go." );
        }
    }

    static class WelcomeEmail extends email {

        @Override
        public void sendMessageBody() {
            System.out.println("Thank you for signing up for our service.");
        }
    }
}
