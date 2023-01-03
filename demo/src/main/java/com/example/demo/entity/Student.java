package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends Member {

    @Column(name = "CLASS")
    String classes;
    @Column(name = "ADMISSION_YEAR_MONTH")
    String admissionYearMonth;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getAdmissionYearMonth() {
        return admissionYearMonth;
    }

    public void setAdmissionYearMonth(String admissionYearMonth) {
        this.admissionYearMonth = admissionYearMonth;
    }

    @Override
    public String toString() {

        return "{" +
                (id == null ? "" : "id=" + id) +
                (name == null ? "" : " ,name=" + name) +
                (gender == null ? "" : " ,gender=" + gender) +
                (classes == null ? "" : " ,classes=" + classes) +
                (admissionYearMonth == null ? "" : " ,admissionYearMonth=" + admissionYearMonth) +
                "}";
    }
}
