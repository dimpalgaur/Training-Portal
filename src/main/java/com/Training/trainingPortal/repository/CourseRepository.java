package com.Training.trainingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Training.trainingPortal.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>
{
	@Query(value = "SELECT * FROM course_table where cover_by=:sName", nativeQuery=true)
	List<Course> courseCoverBy(@Param("sName") String sirName);
	
	//TODO: implement paging using JPA and filtering
}
