package com.Training.trainingPortal.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training.trainingPortal.model.Course;
import com.Training.trainingPortal.repository.CourseRepository;
import com.Training.trainingPortal.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseService cService;

	@Autowired
	CourseRepository cRepo;

	@Override
	public List<Course> getAllCourse() {
		return cRepo.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		return cRepo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return cRepo.save(course);
	}

	@Override
	public String deleteCourse(Integer courseId) {
		cRepo.deleteById(courseId);
		return "Record has been deleted Successfully";
	}

	@Override
	public List<Course> courseCoverBy(String sirName) {
		// TODO Auto-generated method stub
		return cRepo.courseCoverBy(sirName);
	}
}
