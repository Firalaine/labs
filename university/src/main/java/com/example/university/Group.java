package com.example.university;

import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName, List<Student> students) {
        this.groupName = groupName;
        this.students = students;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group: " + groupName + ", Students: " + students;
    }
}
