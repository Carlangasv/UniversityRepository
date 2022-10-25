package perficient.academic.universityapplication.mappers.impl;

import lombok.AllArgsConstructor;
import perficient.academic.universityapplication.dtos.CourseDto;
import perficient.academic.universityapplication.mappers.CourseMapper;
import perficient.academic.universityapplication.mappers.SubjectMapper;
import perficient.academic.universityapplication.models.Course;

import java.util.Objects;


@AllArgsConstructor
public class CourseMapperImpl implements CourseMapper
{
	private final SubjectMapper subjectMapper;

	@Override
	public CourseDto courseToCourseDto(Course course)
	{
		if (Objects.isNull(course))
		{
			return null;
		}
		CourseDto courseDto = new CourseDto();
		courseDto.setName(course.getName());
		courseDto.setSubjectList(
				course.getSubjectList().stream().map(subjectMapper::subjectToSubjectDto).toList());
		return courseDto;
	}
}
