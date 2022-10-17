package perficient.academic.universityApplication.services;

import perficient.academic.universityApplication.model.Subject;

import java.util.List;
import java.util.Optional;


public interface SubjectService
{
	List<Subject> getSubjects();

	Optional<Subject> getSubjectById(Long subjectId);

	Subject getSubjectByName(String subjectName);

	Subject saveSubject(Subject newSubject);

	void removeSubject(Long subjectId);
}
