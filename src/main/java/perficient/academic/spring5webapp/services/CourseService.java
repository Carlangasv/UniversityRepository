package perficient.academic.spring5webapp.services;

import org.springframework.stereotype.Service;
import perficient.academic.spring5webapp.model.Course;
import perficient.academic.spring5webapp.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService
{
	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository)
	{
		this.courseRepository = courseRepository;
	}

	public List<Course> getCourses()
	{
		return courseRepository.findAll();
	}

	public Optional<Course> getCourseById(Long courseId)
	{
		return courseRepository.findById(courseId);
	}

	public Course getCourseByName(String courseName)
	{
		return courseRepository.findCourseByName(courseName);
	}

	public Course saveCourse(Course newCourse)
	{
		return courseRepository.save(newCourse);
	}

	public void removeCourse(Long courseId)
	{
		courseRepository.deleteById(courseId);
	}
}
