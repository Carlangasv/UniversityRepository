package perficient.academic.universityApplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import perficient.academic.universityApplication.model.Subject;
import perficient.academic.universityApplication.repositories.SubjectRepository;
import perficient.academic.universityApplication.services.SubjectService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Getter
class SubjectServiceImpl implements SubjectService
{
	private final SubjectRepository subjectRepository;

	@Override
	public List<Subject> getSubjects()
	{
		return getSubjectRepository().findAll();
	}

	@Override
	public Optional<Subject> getSubjectById(Long subjectId)
	{
		return getSubjectRepository().findById(subjectId);
	}

	@Override
	public Subject getSubjectByName(String subjectName)
	{
		return getSubjectRepository().findSubjectByName(subjectName);
	}

	@Override
	public Subject saveSubject(Subject newSubject)
	{
		return getSubjectRepository().save(newSubject);
	}

	@Override
	public void removeSubject(Long subjectId)
	{
		getSubjectRepository().deleteById(subjectId);
	}
}
