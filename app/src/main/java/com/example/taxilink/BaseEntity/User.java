package com.example.taxilink.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String phoneNumber;
    private List<String> friends;
    private String password;


    public User() {
    }

    public User(String firstname, String lastname, String dob, String phoneNumber, String email, String password) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.friends = new ArrayList<>();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newNumber) {
        phoneNumber = newNumber;
    }

    public List<String> getFriends() {
        return friends;
    }

    public Boolean hasFriend(String user) {
        return friends.contains(user);
    }

    public void addFriend(String friend) {
        friends.add(friend);
    }

    public boolean checkPass(String attempt) {
        return Objects.equals(attempt, this.password);
    }

}
