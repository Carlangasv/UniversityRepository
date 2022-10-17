package perficient.academic.universityApplication.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import perficient.academic.universityApplication.model.Subject;
import perficient.academic.universityApplication.services.SubjectService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
@Getter
public class SubjectController
{
	private final SubjectService subjectService;

	@GetMapping
	public List<Subject> getSubjects()
	{
		return getSubjectService().getSubjects();
	}

	@GetMapping("/{subjectId}")
	public Subject getSubjectById(@PathVariable("subjectId") Long subjectId)
	{
		return getSubjectService().getSubjectById(subjectId).orElseThrow(NoSuchElementException::new);
	}

	@GetMapping("/name/{subjectName}")
	public Subject getSubjectByName(@PathVariable("subjectName") String subjectname)
	{
		return getSubjectService().getSubjectByName(subjectname);
	}

	@PostMapping
	public Subject saveSubject(@RequestBody Subject subject)
	{
		return getSubjectService().saveSubject(subject);
	}

	@DeleteMapping("/{subjectId}")
	public void removeSubject(@PathVariable("subjectId") Long subjectId)
	{
		getSubjectService().removeSubject(subjectId);
	}
}
