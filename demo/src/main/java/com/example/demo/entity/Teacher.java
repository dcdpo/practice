package com.example.demo.entity;

public class Teacher extends Member {

    String subject;
    String jobTitle;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {

        return "{" +
                (super.getId() == null ? "" : "id=" + getId()) +
                (getName() == null ? "" : " ,name=" + getName()) +
                (getGender() == null ? "" : " ,gender=" + getGender()) +
                (subject == null ? "" : " ,subject=" + subject) +
                (jobTitle == null ? "" : " ,jobTitle=" + jobTitle) +
                "}" +
                ("\n");
    }
}
