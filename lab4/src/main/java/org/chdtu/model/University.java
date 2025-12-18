package org.chdtu.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups = new ArrayList<>();

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public University(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
        for (Group g : groups) {
            g.setUniversity(this);
        }}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        for (Group g : groups) {
            g.setUniversity(this);
        }
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.setUniversity(this);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
        group.setUniversity(null);
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
