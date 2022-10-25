package perficient.academic.universityapplication.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.repositories.CourseRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CourseServiceTest
{
	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private CourseServiceImpl courseService;

	@Test
	void shouldReturnEmptyList()
	{
		assertEquals(Collections.emptyList(), courseService.getCourses());
	}

	@Test
	void shouldReturnCourseList()
	{
		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course("Test"));
		courseList.add(new Course("Test2"));
		when(courseRepository.findAll()).thenReturn(courseList);
		assertEquals(courseList, courseService.getCourses());
	}

	@Test
	void shouldReturnCourseWithId()
	{
		Course course = new Course("Test");
		when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
		assertEquals(course, courseService.getCourseById(course.getId()));
	}

	@Test
	void shouldReturnExceptionById()
	{
		Throwable exception = assertThrows(NoSuchElementException.class, () -> courseService.getCourseById(2L));
		assertEquals("No such course with id 2", exception.getMessage());
	}

	@Test
	void shouldReturnCourseWithName()
	{
		Course course = new Course("Test");
		when(courseRepository.findCourseByName(course.getName())).thenReturn(course);
		assertEquals(course, courseService.getCourseByName(course.getName()));
	}

	@Test
	void shouldSaveCourse()
	{
		Course course = new Course("Test");
		when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseService.saveCourse(course));
	}

	@Test
	void shouldRemoveCourse()
	{
		Course course = new Course("Test");
		List<Course> courseList = new ArrayList<>();
		courseList.add(course);
		when(courseRepository.findAll()).thenReturn(courseList);
		assertEquals(courseList, courseService.getCourses());
		courseService.removeCourse(course.getId());
		courseList.remove(course);
		assertEquals(courseList, courseService.getCourses());
	}
}
