package com.workwise.authservice.model;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String image;
    private Provider provider;

    public User(Provider provider, String id, String firstName, String lastName, String image) {
        this.provider = provider;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public Provider getProvider() {
        return this.provider;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImage() {
        return this.image;
    }
}
