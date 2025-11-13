package com.cjbdevlabs.designpatterns.structural;

/*
Change the behavior of an object without creating a sub class
 */
public class DecoratorPattern {

    interface User {

        void printPrivileges();
    }

    abstract static class UserDecorator implements User {

        private final User user;

        public UserDecorator(User user) {
            this.user = user;
        }

        @Override
        public void printPrivileges() {
        }
    }

    static class AdminUser extends UserDecorator {

        public AdminUser(User user) {
            super(user);
        }

        @Override
        public void printPrivileges() {
            super.printPrivileges();
            System.out.println("Admin privileges");
        }
    }

    static class BasicUser implements User {

        @Override
        public void printPrivileges() {
            System.out.println("Can log in");
        }
    }

    static class login {

        public static void main(String[] args) {

            var user = new BasicUser();
            user.printPrivileges();
        }
    }
}
