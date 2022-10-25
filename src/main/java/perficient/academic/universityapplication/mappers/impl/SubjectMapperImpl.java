package perficient.academic.universityapplication.mappers.impl;

import perficient.academic.universityapplication.dtos.SubjectDto;
import perficient.academic.universityapplication.mappers.SubjectMapper;
import perficient.academic.universityapplication.models.Subject;

import java.util.Objects;

public class SubjectMapperImpl implements SubjectMapper
{
	@Override
	public SubjectDto subjectToSubjectDto(Subject subject)
	{
		if (Objects.isNull(subject))
		{
			return null;
		}
		SubjectDto subjectDto = new SubjectDto();
		subjectDto.setName(subject.getName());
		return subjectDto;
	}

}
