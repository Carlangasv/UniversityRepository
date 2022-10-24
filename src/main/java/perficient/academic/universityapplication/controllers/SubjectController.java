package perficient.academic.universityapplication.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityapplication.dto.SubjectDto;
import perficient.academic.universityapplication.model.Subject;
import perficient.academic.universityapplication.services.SubjectService;

import java.util.List;


@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
@Getter
public class SubjectController
{
	private final SubjectService subjectService;

	@GetMapping
	public List<SubjectDto> getSubjects()
	{
		return getSubjectService().getSubjects();
	}

	@GetMapping("/{subjectId}")
	public SubjectDto getSubjectById(@PathVariable("subjectId") Long subjectId)
	{
		return getSubjectService().getSubjectById(subjectId);
	}

	@GetMapping("/name/{subjectName}")
	public SubjectDto getSubjectByName(@PathVariable("subjectName") String subjectname)
	{
		return getSubjectService().getSubjectByName(subjectname);
	}

	@PostMapping
	public SubjectDto saveSubject(@RequestBody Subject subject)
	{
		return getSubjectService().saveSubject(subject);
	}

	@DeleteMapping("/{subjectId}")
	public void removeSubject(@PathVariable("subjectId") Long subjectId)
	{
		getSubjectService().removeSubject(subjectId);
	}
}
