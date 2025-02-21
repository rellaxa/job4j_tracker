package ru.job4j.stream;

public class Customer {
    private String name;

    private String surname;

    private byte age;

    private String login;

    private String password;

    private boolean activated;

    private String gender;

    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", activated=" + activated
                + ", gender='" + gender + '\''
                + '}';
    }

    static class Builder {
        private String name;

        private String surname;

        private byte age;

        private String login;

        private String password;

        private boolean activated;

        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Customer build() {
            Customer customer = new Customer();
            customer.name = name;
            customer.surname = surname;
            customer.age = age;
            customer.login = login;
            customer.password = password;
            customer.activated = activated;
            customer.gender = gender;
            return customer;
        }

        public static void main(String[] args) {
            Customer customer = new Builder()
                    .buildName("name")
                    .buildSurname("surname")
                    .buildAge((byte) 32)
                    .buildLogin("login")
                    .buildPassword("password")
                    .buildActivated(true)
                    .buildGender("male")
                    .build();
            System.out.println(customer);
        }
    }
}
