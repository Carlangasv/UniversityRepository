package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.dto.CourseDto;
import perficient.academic.universityapplication.model.Course;
import perficient.academic.universityapplication.repositories.CourseRepository;
import perficient.academic.universityapplication.services.CourseService;

import java.util.List;


@Service
@AllArgsConstructor
@Getter
public class CourseServiceImpl implements CourseService
{
	private final ModelMapper modelMapper;
	private final CourseRepository courseRepository;

	@Override
	public List<CourseDto> getCourses()
	{
		return getCourseRepository().findAll().stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
	}

	@Override
	public CourseDto getCourseById(Long courseId)
	{
		return modelMapper.map(getCourseRepository().findById(courseId), CourseDto.class);
	}

	@Override
	public CourseDto getCourseByName(String courseName)
	{
		return modelMapper.map(getCourseRepository().findCourseByName(courseName), CourseDto.class);
	}

	@Override
	public CourseDto saveCourse(Course newCourse)
	{
		return modelMapper.map(getCourseRepository().save(newCourse), CourseDto.class) ;
	}

	@Override
	public void removeCourse(Long courseId)
	{
		getCourseRepository().deleteById(courseId);
	}
}
