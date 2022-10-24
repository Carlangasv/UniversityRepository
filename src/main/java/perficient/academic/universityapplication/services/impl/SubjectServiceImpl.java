package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.dto.SubjectDto;
import perficient.academic.universityapplication.model.Subject;
import perficient.academic.universityapplication.repositories.SubjectRepository;
import perficient.academic.universityapplication.services.SubjectService;

import java.util.List;


@Service
@AllArgsConstructor
@Getter
class SubjectServiceImpl implements SubjectService
{
	private final ModelMapper modelMapper;
	private final SubjectRepository subjectRepository;

	@Override
	public List<SubjectDto> getSubjects()
	{
		return getSubjectRepository().findAll().stream().map(subject -> modelMapper.map(subject, SubjectDto.class)).toList();
	}

	@Override
	public SubjectDto getSubjectById(Long subjectId)
	{
		return modelMapper.map(getSubjectRepository().findById(subjectId), SubjectDto.class);
	}

	@Override
	public SubjectDto getSubjectByName(String subjectName)
	{
		return modelMapper.map(getSubjectRepository().findSubjectByName(subjectName), SubjectDto.class);
	}

	@Override
	public SubjectDto saveSubject(Subject newSubject)
	{
		return modelMapper.map(getSubjectRepository().save(newSubject), SubjectDto.class);
	}

	@Override
	public void removeSubject(Long subjectId)
	{
		getSubjectRepository().deleteById(subjectId);
	}
}
