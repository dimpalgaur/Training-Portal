package com.Training.trainingPortal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training.trainingPortal.model.Course;
import com.Training.trainingPortal.serviceImpl.CourseServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/CourseHome")
public class CourseController 
{
	@Autowired
	CourseServiceImpl cServiceImple;
 
	@GetMapping(value="/getCourse")
	public List<Course> getAllCourses() 
	{
		return cServiceImple.getAllCourse();
	}
    
	@PostMapping(value="/createCourse")
	public Course saveCourses(@RequestBody Course course) 
	{
		return cServiceImple.saveCourse(course);
	}

	@PutMapping(value="/updaterecords")
	public Course updateCourses(@RequestBody Course course) 
	{
		return cServiceImple.updateCourse(course);
	}

	@DeleteMapping(value="/deleteRecords/{courseId}")
	public String deleteCourses(@PathVariable Integer courseId) 
	{
		return cServiceImple.deleteCourse(courseId);
	}
	
	@GetMapping(value="/getDetails/{sirName}")
	public List<Course> courseCoverBy(@PathVariable String sirName) 
	{	
		return cServiceImple.courseCoverBy(sirName);
	}

}
