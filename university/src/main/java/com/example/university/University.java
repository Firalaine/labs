package com.example.university;

public class University {
    private String universityName;
    private Group group;

    public University(String universityName, Group group) {
        this.universityName = universityName;
        this.group = group;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void printInfo() {
        System.out.println("University: " + universityName);
        System.out.println(group);
    }
}
