package com.workwise.uiservice.model;

public class Job {
    private String id;
    private String title;
    private String description;
    private String location;
    private String company;
    private Double pay;
    private String date;
    private int interaction;
    private Recruiter recruiter;
    private String url;

    public Job(Recruiter recruiter, String id, String title, String description, String location,
               Double pay, String date, String url, int interaction) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = recruiter.getCompany();
        this.pay = pay;
        this.date = date;
        this.interaction = interaction;
        this.recruiter = recruiter;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Recruiter getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
