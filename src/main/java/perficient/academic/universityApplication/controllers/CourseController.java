package perficient.academic.universityApplication.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityApplication.model.Course;
import perficient.academic.universityApplication.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/courses")
@AllArgsConstructor
@Getter
public class CourseController
{
	private final CourseService courseService;

	@GetMapping
	public List<Course> getCourses()
	{
		return getCourseService().getCourses();
	}

	@GetMapping("/{courseId}")
	public Course getCourseById(@PathVariable("courseId") Long courseId)
	{
		return getCourseService().getCourseById(courseId).orElse(new Course());
	}

	@GetMapping("/name/{courseName}")
	public Course getCourseByName(@PathVariable("courseName") String courseName)
	{
		return getCourseService().getCourseByName(courseName);
	}

	@PostMapping
	public Course saveCourse(@RequestBody Course course)
	{
		return getCourseService().saveCourse(course);
	}

	@DeleteMapping("/{courseId}")
	public void removeCourse(@PathVariable("courseId") Long courseId)
	{
		getCourseService().removeCourse(courseId);
	}
}
