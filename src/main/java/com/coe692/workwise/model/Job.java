package com.coe692.workwise.model;

public class Job {
    private String title;
    private String description;
    private String location;
    private String company;
    private Double pay;
    private String date;
    private int interaction;
    private String recruiter;

    public Job(String title, String description, String location, String company, Double pay, String date, int interaction, String recruiter) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.pay = pay;
        this.date = date;
        this.interaction = interaction;
        this.recruiter = recruiter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getInteraction() {
        return interaction;
    }

    public void setInteraction(int interaction) {
        this.interaction = interaction;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter;
    }
}
