package org.chdtu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Group {

    @Value("${group.name}")
    private String groupName;

    private final List<Student> students;

    @Autowired
    public Group(List<Student> students) {
        this.students = students;
    }

    @PostConstruct
    public void init() {
        System.out.println("Group INIT: група створена → " + groupName);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Group DESTROY");
    }

    @Override
    public String toString() {
        return "Група: " + groupName + ", Студент: " + students;
    }
}
