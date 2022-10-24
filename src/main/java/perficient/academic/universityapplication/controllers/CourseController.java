package perficient.academic.universityapplication.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityapplication.dto.CourseDto;
import perficient.academic.universityapplication.model.Course;
import perficient.academic.universityapplication.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/courses")
@AllArgsConstructor
@Getter
public class CourseController
{
	private final CourseService courseService;

	@GetMapping
	public List<CourseDto> getCourses()
	{
		return getCourseService().getCourses();
	}

	@GetMapping("/{courseId}")
	public CourseDto getCourseById(@PathVariable("courseId") Long courseId)
	{
		return getCourseService().getCourseById(courseId);
	}

	@GetMapping("/name/{courseName}")
	public CourseDto getCourseByName(@PathVariable("courseName") String courseName)
	{
		return getCourseService().getCourseByName(courseName);
	}

	@PostMapping
	public CourseDto saveCourse(@RequestBody Course course)
	{
		return getCourseService().saveCourse(course);
	}

	@DeleteMapping("/{courseId}")
	public void removeCourse(@PathVariable("courseId") Long courseId)
	{
		getCourseService().removeCourse(courseId);
	}
}
