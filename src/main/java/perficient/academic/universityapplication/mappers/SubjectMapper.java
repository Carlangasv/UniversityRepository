package perficient.academic.universityapplication.mappers;

import org.mapstruct.Mapper;
import perficient.academic.universityapplication.dtos.SubjectDto;
import perficient.academic.universityapplication.models.Subject;


@Mapper(componentModel = "spring")
public interface SubjectMapper
{
	SubjectDto subjectToSubjectDto(Subject subject);
}
