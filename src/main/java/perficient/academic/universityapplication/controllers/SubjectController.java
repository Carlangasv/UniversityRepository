package perficient.academic.universityapplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityapplication.dtos.SubjectDto;
import perficient.academic.universityapplication.mappers.SubjectMapper;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.services.SubjectService;

import java.util.List;


@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
@Getter
public class SubjectController
{
	private final SubjectService subjectService;

	private final SubjectMapper subjectMapper;

	@GetMapping
	public List<SubjectDto> getSubjects()
	{
		return getSubjectService().getSubjects().stream().map(getSubjectMapper()::subjectToSubjectDto).toList();
	}

	@GetMapping("/{subjectId}")
	public SubjectDto getSubjectById(@PathVariable("subjectId") Long subjectId)
	{
		return getSubjectMapper().subjectToSubjectDto(getSubjectService().getSubjectById(subjectId));
	}

	@GetMapping("/name/{subjectName}")
	public SubjectDto getSubjectByName(@PathVariable("subjectName") String subjectname)
	{
		return getSubjectMapper().subjectToSubjectDto(getSubjectService().getSubjectByName(subjectname));
	}

	@PostMapping
	public SubjectDto saveSubject(@Valid @RequestBody Subject subject)
	{
		return getSubjectMapper().subjectToSubjectDto(subjectService.saveSubject(subject));
	}

	@DeleteMapping("/{subjectId}")
	public void removeSubject(@PathVariable("subjectId") Long subjectId)
	{
		getSubjectService().removeSubject(subjectId);
	}
}
