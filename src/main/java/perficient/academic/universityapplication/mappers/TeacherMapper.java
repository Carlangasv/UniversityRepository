package perficient.academic.universityapplication.mappers;

import org.mapstruct.Mapper;
import perficient.academic.universityapplication.dtos.TeacherDto;
import perficient.academic.universityapplication.models.Teacher;


@Mapper(componentModel = "spring")
public interface TeacherMapper
{
	TeacherDto teacherToTeacherDto(Teacher teacher);
}
