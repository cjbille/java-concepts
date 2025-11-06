package com.cjbdevlabs.designpatterns.creational;

import java.time.LocalDate;

/*
The builder pattern helps to avoid constructors with lots of parameters or multiple constructors
with different parameters.
 */
public class BuilderPattern {

     static class Person {

        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final LocalDate dateOfBirth;
        private final String emailAddress;
        private final String phoneNumber;

        private Person(PersonBuilder personBuilder) { // make private so no one can use constructor directly
            this.firstName = personBuilder.firstName;
            this.middleName = personBuilder.middleName;
            this.lastName = personBuilder.lastName;
            this.dateOfBirth = personBuilder.dateOfBirth;
            this.emailAddress = personBuilder.emailAddress;
            this.phoneNumber = personBuilder.phoneNumber;
            if (firstName == null || lastName == null) {
                throw new IllegalArgumentException("First name and last name must not be null");
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", emailAddress='" + emailAddress + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

         static class PersonBuilder {

            private final String firstName;
            private String middleName;
            private final String lastName;
            private LocalDate dateOfBirth;
            private String emailAddress;
            private String phoneNumber;

            public PersonBuilder(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public PersonBuilder middleName(String middleName) {
                this.middleName = middleName;
                return this;
            }

            public PersonBuilder dateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }

            public PersonBuilder emailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
                return this;
            }

            public PersonBuilder phoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }

    static class SalesLeadTracker {

//        Person person1 = new Person("Tracy", null,
//                "Westbay", LocalDate.of(1985,1,1),
//                "tracy@example.com",null);
//        Person person2 = new Person("Jerome", "Henry",
//                "Donaldson", null,
//                null, "123456789");

        // with builder pattern
        Person person1 = new Person.PersonBuilder("Tracy", "Westbay")
                .dateOfBirth(LocalDate.of(1985,1,1))
                .emailAddress("tracy@example.com")
                .build();
        Person person2 = new Person.PersonBuilder("Jerome", "Donaldson")
                .middleName("Henry")
                .phoneNumber("123456789")
                .build();

        private static void addPersonToLeadTracker(Person person) {
            System.out.println("A new lead was added to the lead tracker: \n" + person);
        }
    }
}
