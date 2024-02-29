package com.coe692.workwise.model;

public class Candidate extends User {
    final String candidateId;
    final String experience;
    final String skills;
    final String description;
    final boolean searchable;
    public Candidate(String userId, Provider provider, String firstname, String lastname, String image, String candidateId,  String experience, String skills, String description, boolean searchable) {
        super(userId, provider, firstname, lastname, image);
        this.candidateId = candidateId;
        this.experience = experience;
        this.skills = skills;
        this.description = description;
        this.searchable = searchable;
    }
}
