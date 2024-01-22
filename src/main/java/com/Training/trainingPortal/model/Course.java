package com.Training.trainingPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CourseTable")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseID")
	public int courseID;
	@Column(name = "courseName")
	public String courseName;
	@Column(name = "duration")
	public int duration;
	@Column(name = "coverBy")
	public String coverBy;

	public Course(int courseID, String courseName, int duration, String coverBy) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.duration = duration;
		this.coverBy = coverBy;
	}

	public Course() {
		super();
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCoverBy() {
		return coverBy;
	}

	public void setCoverBy(String coverBy) {
		this.coverBy = coverBy;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", duration=" + duration + ", coverBy="
				+ coverBy + "]";
	}

}
