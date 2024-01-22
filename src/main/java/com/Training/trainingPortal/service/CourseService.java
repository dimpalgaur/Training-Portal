package com.Training.trainingPortal.service;

import java.util.List;

import com.Training.trainingPortal.model.Course;

public interface CourseService
{
       List<Course> getAllCourse();
      
       Course saveCourse(Course course);
      
       Course updateCourse(Course course);

	   String deleteCourse(Integer courseId);

	   List<Course> courseCoverBy(String sirName);
	         
}
