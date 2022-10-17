package perficient.academic.universityApplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import perficient.academic.universityApplication.model.Course;
import perficient.academic.universityApplication.repositories.CourseRepository;
import perficient.academic.universityApplication.services.CourseService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Getter
public class CourseServiceImpl implements CourseService
{

	private final CourseRepository courseRepository;

	@Override
	public List<Course> getCourses()
	{
		return getCourseRepository().findAll();
	}

	@Override
	public Optional<Course> getCourseById(Long courseId)
	{
		return getCourseRepository().findById(courseId);
	}

	@Override
	public Course getCourseByName(String courseName)
	{
		return getCourseRepository().findCourseByName(courseName);
	}

	@Override
	public Course saveCourse(Course newCourse)
	{
		return getCourseRepository().save(newCourse);
	}

	@Override
	public void removeCourse(Long courseId)
	{
		getCourseRepository().deleteById(courseId);
	}
}
