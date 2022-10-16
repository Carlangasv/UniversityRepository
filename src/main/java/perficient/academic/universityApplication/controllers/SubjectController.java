package perficient.academic.universityApplication.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perficient.academic.universityApplication.model.Subject;
import perficient.academic.universityApplication.services.SubjectService;

import java.util.List;


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
}
