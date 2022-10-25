package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.models.Subject;

import java.util.List;


public interface SubjectService
{
	List<Subject> getSubjects();

	Subject getSubjectById(Long subjectId);

	Subject getSubjectByName(String subjectName);

	Subject saveSubject(Subject newSubject);

	void removeSubject(Long subjectId);
}
