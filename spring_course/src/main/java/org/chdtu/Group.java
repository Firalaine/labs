package org.chdtu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Group {

    @Value("${group.name}")
    private String groupName;

    private final Student student;

    @Autowired
    public Group(Student student) {
        this.student = student;
    }

    @PostConstruct
    public void init() {
        System.out.println("Group INIT: група створена → " + groupName);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Group DESTROY");
    }

    public void initGroup() {
        System.out.println("Group.initGroup() викликаний");
    }

    @Override
    public String toString() {
        return "Група: " + groupName + ", Студенти: [" + student + "]";
    }
}
