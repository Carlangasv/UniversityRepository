package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.repositories.CourseRepository;
import perficient.academic.universityapplication.repositories.SubjectRepository;
import perficient.academic.universityapplication.services.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
@Getter
public class CourseServiceImpl implements CourseService
{
	private final ModelMapper modelMapper;
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;

	@Override
	public List<Course> getCourses()
	{
		return getCourseRepository().findAll();
	}

	@Override
	public Course getCourseById(Long courseId)
	{
		return getCourseRepository().findById(courseId)
				.orElseThrow(() -> new NoSuchElementException("No such course with id " + courseId));
	}

	@Override
	public Course getCourseByName(String courseName)
	{
		return getCourseRepository().findCourseByName(courseName);
	}

	@Override
	public Course saveCourse(Course newCourse)
	{
		List<Subject> subjects = new ArrayList<>();
		newCourse.getSubjectList().forEach(e -> {
			if (subjectRepository.findById(e.getId()).isPresent())
			{
				subjects.add(subjectRepository.findById(e.getId()).get());
			}
			else
			{
				subjects.add(subjectRepository.save(e));
			}
		});
		getCourseRepository().save(newCourse);
		subjects.forEach(e -> e.setCourse(newCourse));
		newCourse.setSubjectList(subjects);
		return getCourseRepository().save(newCourse);
	}

	@Override
	public void removeCourse(Long courseId)
	{
		getCourseRepository().deleteById(courseId);
	}
}
