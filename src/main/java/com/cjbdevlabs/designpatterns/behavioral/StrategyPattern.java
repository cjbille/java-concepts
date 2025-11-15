package com.cjbdevlabs.designpatterns.behavioral;

/*
In the strategy pattern, the word strategy usually refers to an algorithm.
When you use this pattern, you define a family of algorithms and make them interchangeable.
 */
public class StrategyPattern {

    static class App {

        public static void main(String[] args) {

            var loginPage = new LoginPage();

            loginPage.logInUser(Authenticator.passwordAuthenticator);
            loginPage.logInUser(Authenticator.ssoAuthenticator);
        }
    }

    @FunctionalInterface
     interface Authenticator {

        void logIn();

        Authenticator passwordAuthenticator = () -> System.out.println("Password Authenticator");

        Authenticator ssoAuthenticator = () -> System.out.println("SSO Authenticator");
    }

    static class LoginPage {

        public void logInUser(Authenticator authenticator) {
            authenticator.logIn();
        }
    }
}
