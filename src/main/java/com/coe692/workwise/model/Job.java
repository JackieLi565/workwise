package com.coe692.workwise.model;

public class Job {
    public final String id;
    public final String title;
    public final String description;
    public final String location;
    public final String company;
    public final Double pay;
    public final String date;
    public final int interaction;
    public final String recruiter;

    public Job(String id,String title, String description, String location, String company, Double pay, String date, int interaction, String recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.pay = pay;
        this.date = date;
        this.interaction = interaction;
        this.recruiter = recruiter;
    }
}
