package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.dto.CourseDto;
import perficient.academic.universityapplication.model.Course;

import java.util.List;


public interface CourseService
{
	List<CourseDto> getCourses();

	CourseDto getCourseById(Long courseId);

	CourseDto getCourseByName(String courseName);

	CourseDto saveCourse(Course newCourse);

	void removeCourse(Long courseId);
}
