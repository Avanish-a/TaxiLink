package com.example.taxilink.BaseEntity;

import java.util.ArrayList;

public class Profile {

    private final String userID;
    private final String firstname;
    private final String lastname;
    private final String dob;
    private Byte[] profilePicture;
    private String email;
    private String phoneNumber;
    private ArrayList<Profile> friends;

    public Profile(String userID, String firstname, String lastname, String email, String dob, String phoneNumber) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        friends = new ArrayList<Profile>();
    }

    public String getUserID() {
        return this.userID;
    }

    public String getName(int nameType) throws IllegalArgumentException {
        if (nameType < 1 || nameType > 3) {
            throw new IllegalArgumentException("Argument must be between 1 and 3");
        }
        if (nameType == 1) {
            return this.firstname;
        } else if (nameType == 2) {
            return this.lastname;
        }
        return this.firstname + this.lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Profile> getFriends() {
        return this.friends;
    }

    public Byte[] getPicture() {
        return this.profilePicture;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    public void setPicture(Byte[] picture) {
        this.profilePicture = picture;
    }

    public Boolean hasFriend(Profile user) {
        return this.friends.contains(user);
    }

    public void addFriend(Profile friend) {
        this.friends.add(friend);
    }

}
