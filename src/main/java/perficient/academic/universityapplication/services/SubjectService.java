package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.dto.SubjectDto;
import perficient.academic.universityapplication.model.Subject;

import java.util.List;


public interface SubjectService
{
	List<SubjectDto> getSubjects();

	SubjectDto getSubjectById(Long subjectId);

	SubjectDto getSubjectByName(String subjectName);

	SubjectDto saveSubject(Subject newSubject);

	void removeSubject(Long subjectId);
}
