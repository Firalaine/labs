package com.example.university;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Group group = context.getBean("group", Group.class);
        System.out.println(group);

        context.close();
    }
}
