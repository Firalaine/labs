package com.example.university;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Student student = context.getBean("student1", Student.class);
        System.out.println(student);
        context.close();
    }
}
