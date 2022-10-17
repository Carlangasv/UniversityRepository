package perficient.academic.universityApplication.services;

import perficient.academic.universityApplication.model.Course;

import java.util.List;
import java.util.Optional;


public interface CourseService
{
	List<Course> getCourses();

	Optional<Course> getCourseById(Long courseId);

	Course getCourseByName(String courseName);

	Course saveCourse(Course newCourse);

	void removeCourse(Long courseId);
}
