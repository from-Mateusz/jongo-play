package cz.mateusz.jongo.practice.models;

public class FullName {

    private String firstName;

    private String lastName;

    private FullName() {}

    private FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullName create(String firstName, String lastName) {
        return new FullName(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
