package perficient.academic.universityApplication.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perficient.academic.universityApplication.model.Course;
import perficient.academic.universityApplication.repositories.CourseRepository;
import perficient.academic.universityApplication.services.impl.CourseServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CourseServiceTest
{
	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private CourseServiceImpl courseServiceImpl;

	@Test
	void shouldReturnEmptyList(){
		assertEquals(Collections.emptyList(), courseServiceImpl.getCourses());
	}

	@Test
	void getCourses()
	{
		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course("Test"));
		courseList.add(new Course("Test2"));
		when(courseRepository.findAll()).thenReturn(courseList);
		assertEquals(courseList, courseServiceImpl.getCourses());
	}

	@Test
	void getCourseById()
	{
		Course course = new Course("Test");
		when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
		assertEquals(course, courseServiceImpl.getCourseById(1L).orElse(new Course()));
	}

	@Test
	void getCourseByName()
	{
		Course course = new Course("Test");
		when(courseRepository.findCourseByName("Test")).thenReturn(course);
		assertEquals(course, courseServiceImpl.getCourseByName("Test"));

		when(courseRepository.findCourseByName("NullTest")).thenReturn(null);
		assertNull(courseServiceImpl.getCourseByName("NullTest"));
	}
}
