package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Teacher extends Member {

    @Column(name = "SUBJECT")
    String subject;
    @Column(name = "JOB_TITLE")
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
                (id == null ? "" : "id=" + id) +
                (name == null ? "" : " ,name=" + name) +
                (gender == null ? "" : " ,gender=" + gender) +
                (subject == null ? "" : " ,subject=" + subject) +
                (jobTitle == null ? "" : " ,jobTitle=" + jobTitle) +
                "}"+
                ("\n");
    }
}
