package com.workwise.uiservice.model;
public class Recruiter {
    private String id;
    private String name;
    private String lastname;
    private String image;
    private String company;

    public Recruiter(String id, String name, String lastname, String image, String company) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
        this.company = company;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }
}