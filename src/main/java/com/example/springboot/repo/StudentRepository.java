package com.example.springboot.repo;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Passport;
import com.example.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class,id);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z120967");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public void playWithEntityManager(){
        Student student1 = new Student("Web Services in 100 Steps");
        em.persist(student1);
        Student student2 = new Student("Angular Js in 100 Steps");
        em.persist(student2);

        em.flush();

        student1.setName("Web Services in 100 Steps - Updated");
        student2.setName("Angular Js in 100 Steps - Updated");

        em.refresh(student1);

        em.flush();
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);
        student.addCourse(course);
        course.addStudent(student);
        //persist the owning side
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
        em.persist(course);
    }

}
