package com.workwise.candidateservice.model;

public class User {
    protected String id;
    protected Provider provider;
    protected String firstName;
    protected String lastName;
    protected String image;

    public User(Provider provider, String id, String firstName, String lastName, String image) {
        this.id = id;
        this.provider = provider;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
