package com.workwise.candidateservice.model;

public class Candidate extends User {
    private String candidateId;
    private String experience;
    private String skills;
    private String description;
    private boolean searchable;

    public Candidate(String userId, Provider provider, String firstname, String lastname, String image,
                     String candidateId, String experience, String skills, String description, boolean searchable) {

        super(provider, userId, firstname, lastname, image);
        this.candidateId = candidateId;
        this.experience = experience;
        this.skills = skills;
        this.description = description;
        this.searchable = searchable;
    }

    public String getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSearchable() {
        return this.searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }
}
