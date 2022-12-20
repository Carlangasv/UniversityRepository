package perficient.academic.universityapplication.mappers;

import org.mapstruct.Mapper;
import perficient.academic.universityapplication.dtos.StudentDto;
import perficient.academic.universityapplication.models.Student;


@Mapper(componentModel = "spring")
public interface StudentMapper
{
	StudentDto studentToStudentDto(Student student);
}
