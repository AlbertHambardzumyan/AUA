// Copyright (c) 2016 Albert Hambardzumyan
// All rights reserved.
// This software is released under the BSD license.
package store.user;

/**
 * @author Albert Hambardzumyan
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public User(String firstName, String lastname, String email, String phone, String password) {
        setFirstName(firstName);
        setLastname(lastname);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    protected void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    protected void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }
}
