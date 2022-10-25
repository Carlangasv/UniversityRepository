package perficient.academic.universityapplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityapplication.dtos.CourseDto;
import perficient.academic.universityapplication.mappers.CourseMapper;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/courses")
@AllArgsConstructor
@Getter
public class CourseController
{
	private final CourseService courseService;

	private final CourseMapper courseMapper;

	@GetMapping
	public List<CourseDto> getCourses()
	{
		return getCourseService().getCourses().stream().map(courseMapper::courseToCourseDto).toList();
	}

	@GetMapping("/{courseId}")
	public CourseDto getCourseById(@PathVariable("courseId") Long courseId)
	{
		return courseMapper.courseToCourseDto(getCourseService().getCourseById(courseId));
	}

	@GetMapping("/name/{courseName}")
	public CourseDto getCourseByName(@PathVariable("courseName") String courseName)
	{
		return courseMapper.courseToCourseDto(getCourseService().getCourseByName(courseName));
	}

	@PostMapping
	public CourseDto saveCourse(@Valid @RequestBody Course course)
	{
		return courseMapper.courseToCourseDto(getCourseService().saveCourse(course));
	}

	@DeleteMapping("/{courseId}")
	public void removeCourse(@PathVariable("courseId") Long courseId)
	{
		getCourseService().removeCourse(courseId);
	}
}
