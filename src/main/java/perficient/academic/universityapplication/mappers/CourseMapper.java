package perficient.academic.universityapplication.mappers;

import org.mapstruct.Mapper;
import perficient.academic.universityapplication.dtos.CourseDto;
import perficient.academic.universityapplication.models.Course;


@Mapper(componentModel = "spring")
public interface CourseMapper
{
	CourseDto courseToCourseDto(Course course);
}
