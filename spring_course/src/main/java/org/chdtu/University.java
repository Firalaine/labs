package org.chdtu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class University {

    @Value("${university.name}")
    private String universityName;

    private Group group;

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }

    @PostConstruct
    public void init() {
        System.out.println("University INIT: " + universityName + " створено");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("University DESTROY");
    }

    public void printInfo() {
        System.out.println("Університет: " + universityName);
        System.out.println(group);
    }
}
