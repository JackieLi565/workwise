package com.coe692.workwise.model;

public class Recruiter extends User{
    final String company;
    final String recruiterId;
    public Recruiter(String userId, Provider provider, String firstname, String lastname, String image, String recruiterId, String company) {
        super(userId, provider, firstname, lastname, image);
        this.company = company;
        this.recruiterId = recruiterId;
    }
}
