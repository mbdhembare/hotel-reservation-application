package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Customer(final String firstName, final String lastName, final String email){
        this.isValidEmail(email);

        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }


    private void isValidEmail(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
