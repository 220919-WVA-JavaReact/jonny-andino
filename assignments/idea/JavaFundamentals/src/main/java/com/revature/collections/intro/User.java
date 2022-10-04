package com.revature.collections.intro;

import java.io.Serializable;
import java.util.Objects;

// This class is a model for a User object, should have a lot of the properties we talked about yesterday
public class User implements Serializable {

    // Used for Serialization, or the process of converting the object into a byte stream, aka outputting it into a file
    private static final long serialVersionUID = 1L;

    // Transient means when this is serialized, this value doesn't get converted into the byte stream and will become null
    private transient String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    public User() {	}

    public User(String firstName, String lastName, String username, String password, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, username, password, email);
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
                + password + ", email=" + email + "]";
    }

}

