package org.chdtu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;

    public Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " years)";
    }
}
