package perficient.academic.spring5webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import perficient.academic.spring5webapp.model.Course;
import perficient.academic.spring5webapp.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController
{
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService)
	{
		this.courseService = courseService;
	}

	@GetMapping
	public List<Course> getCourses()
	{
		return courseService.getCourses();
	}

	@GetMapping("/{courseId}")
	public Course getCourseById(@PathVariable("courseId") Long courseId)
	{
		return courseService.getCourseById(courseId).orElse(new Course());
	}

	@GetMapping("/name/{courseName}")
	public Course getCourseByName(@PathVariable("courseName") String courseName)
	{
		return courseService.getCourseByName(courseName);
	}

	@PostMapping
	public Course saveCourse(@RequestBody Course course)
	{
		return courseService.saveCourse(course);
	}

	@DeleteMapping("/{courseId}")
	public void removeCourse(@PathVariable("courseId") Long courseId)
	{
		courseService.removeCourse(courseId);
	}
}
