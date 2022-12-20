package perficient.academic.universityapplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public SubjectDto getSubjectByName(@PathVariable("subjectName") String subjectName)
	{
		return getSubjectMapper().subjectToSubjectDto(getSubjectService().getSubjectByName(subjectName));
	}

	@PostMapping
	public SubjectDto saveSubject(@Valid @RequestBody Subject subject)
	{
		return getSubjectMapper().subjectToSubjectDto(subjectService.saveSubject(subject));
	}

	@PutMapping("/{subjectId}")
	public SubjectDto updateSubjectById(@PathVariable("subjectId") Long subjectId, @Valid @RequestBody Subject updatedSubject)
	{
		return getSubjectMapper().subjectToSubjectDto(subjectService.updateSubjectById(subjectId, updatedSubject));
	}

	@DeleteMapping("/{subjectId}")
	public void removeSubject(@PathVariable("subjectId") Long subjectId)
	{
		getSubjectService().removeSubject(subjectId);
	}
}
