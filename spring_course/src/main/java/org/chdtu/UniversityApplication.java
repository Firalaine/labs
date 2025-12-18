package org.chdtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "org.chdtu")
public class    UniversityApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(UniversityApplication.class, args);

        University university = context.getBean(University.class);
        university.printInfo();

        Group group = context.getBean(Group.class);
        group.initGroup();

        Student student = context.getBean(Student.class);
        student.setName("Test");

        context.close();
    }
}
