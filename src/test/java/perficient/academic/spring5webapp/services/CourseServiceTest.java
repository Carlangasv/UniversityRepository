package perficient.academic.spring5webapp.services;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perficient.academic.spring5webapp.model.Course;
import perficient.academic.spring5webapp.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		assertEquals(Collections.emptyList(), courseService.getCourses());
		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course("Test"));
		courseList.add(new Course("Test2"));
		when(courseRepository.findAll()).thenReturn(courseList);
		assertEquals(courseList, courseService.getCourses());
	}

	@Test
	void getCourseById()
	{
		Course course = new Course("Test");
		when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
		assertEquals(course, courseService.getCourseById(1L).orElse(new Course()));
	}

	@Test
	void getCourseByName()
	{
		Course course = new Course("Test");
		when(courseRepository.findCourseByName("Test")).thenReturn(course);
		assertEquals(course, courseService.getCourseByName("Test"));

		when(courseRepository.findCourseByName("NullTest")).thenReturn(null);
		assertNull(courseService.getCourseByName("NullTest"));
	}
}
