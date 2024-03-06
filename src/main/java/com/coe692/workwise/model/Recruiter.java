package com.coe692.workwise.model;

public class Recruiter extends User {
    private String company;
    private String recruiterId;

    public Recruiter(String userId, Provider provider, String firstname, String lastname, String image,
                     String recruiterId, String company) {
        super(userId, provider, firstname, lastname, image);
        this.company = company;
        this.recruiterId = recruiterId;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRecruiterId() {
        return this.recruiterId;
    }

    public void setRecruiterId(String recruiterId) {
        this.recruiterId = recruiterId;
    }
}
