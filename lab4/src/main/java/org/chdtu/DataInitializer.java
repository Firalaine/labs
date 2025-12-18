package org.chdtu;

import org.chdtu.model.*;
import org.chdtu.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UniversityRepository universityRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public DataInitializer(UniversityRepository universityRepository,
                           GroupRepository groupRepository,
                           StudentRepository studentRepository,
                           CourseRepository courseRepository) {
        this.universityRepository = universityRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        University uni = new University("CHDTU");
        universityRepository.save(uni);

        Group group = new Group("PZ-2204");
        group.setUniversity(uni);
        groupRepository.save(group);

        Course course1 = new Course("Math");
        Course course2 = new Course("Physics");
        courseRepository.saveAll(Arrays.asList(course1, course2));

        StudentDetail detail1 = new StudentDetail("Kyiv", "123456789");
        StudentDetail detail2 = new StudentDetail("Lviv", "987654321");

        Student s1 = new Student("Ivan Ivanov", 20);
        Student s2 = new Student("Petro Petrov", 21);

        s1.setDetail(detail1);
        s2.setDetail(detail2);

        s1.setGroup(group);
        s2.setGroup(group);

        s1.addCourse(course1);
        s1.addCourse(course2);
        s2.addCourse(course1);

        studentRepository.saveAll(Arrays.asList(s1, s2));

        System.out.println("Дані успішно ініціалізовано");
        System.out.println("Університет: " + uni.getName());
        System.out.println("Група: " + group.getGroupName() + " (студентів: " + group.getStudents().size() + ")");
        System.out.println("Студент 1: " + s1.getName() +
                ", деталі: " + (s1.getDetail() != null ? s1.getDetail().getAddress() : "немає") +
                ", курсів: " + s1.getCourses().size());
        System.out.println("Студент 2: " + s2.getName() +
                ", деталі: " + (s2.getDetail() != null ? s2.getDetail().getAddress() : "немає") +
                ", курсів: " + s2.getCourses().size());
    }
}