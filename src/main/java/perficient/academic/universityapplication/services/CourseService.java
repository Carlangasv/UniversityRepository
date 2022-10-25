package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.models.Course;

import java.util.List;


public interface CourseService
{
	List<Course> getCourses();

	Course getCourseById(Long courseId);

	Course getCourseByName(String courseName);

	Course saveCourse(Course newCourse);

	void removeCourse(Long courseId);
}
