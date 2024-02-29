package com.coe692.workwise.model;


public class User {
    public String id;
    public Provider provider;
    public String firstName;
    public String lastName;

    protected User(String id, Provider provider, String firstName, String lastName, String image) {
        this.id = id;
        this.provider = provider;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
