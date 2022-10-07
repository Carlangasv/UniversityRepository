package perficient.academic.spring5webapp.services;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import perficient.academic.spring5webapp.model.Course;
import perficient.academic.spring5webapp.repositories.CourseRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CourseServiceTest
{
	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private CourseService courseService;

	@Test
	void getCourses()
	{
		assertEquals(Lists.emptyList(), courseService.getCourses());
	}

	@Test
	void getCourseById()
	{
		Course course = new Course();
		course.setId(123L);
		course.setName("Test");
		when(courseRepository.findById(123L)).thenReturn(Optional.of(course));
		assertEquals(course, courseService.getCourseById(123L).get());
	}

	@Test
	void getCourseByName()
	{
		Course course = new Course();
		course.setId(123L);
		course.setName("Test");
		when(courseRepository.findCourseByName("Test")).thenReturn(course);
		assertEquals(course, courseService.getCourseByName("Test"));
	}
}
