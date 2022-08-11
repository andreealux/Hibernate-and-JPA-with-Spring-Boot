package com.example.springboot.repo;

import com.example.springboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);

    //jpql
    @Query("Select c From Course  c where c.name like '%100 Steps'")
    List<Course> courseWith100StepsInName();

    //Native Query
//    @Query(value = "Select * From Course  c where c.name like '%100 Steps'", nativeQuery = true)
//    List<Course> courseWith100StepsInNameUsingNativQuery();

    //Named Query
//    @Query(name = "query_get_100_Steps_courses'")
//    List<Course> courseWith100StepsInNameUsingNamedQuery();
}
