package com.example.demo.entity;

public class Student extends Member {

    private String classes;
    private String admissionYearMonth;

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
                (super.getId() == null ? "" : "id=" + super.getId()) +
                (super.getName() == null ? "" : " ,name=" + super.getName()) +
                (super.getGender() == null ? "" : " ,gender=" + super.getGender()) +
                (classes == null ? "" : " ,classes=" + classes) +
                (admissionYearMonth == null ? "" : " ,admissionYearMonth=" + admissionYearMonth) +
                "}" +
                ("\n");
    }
}
