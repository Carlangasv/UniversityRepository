package perficient.academic.universityapplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perficient.academic.universityapplication.models.Student;
import perficient.academic.universityapplication.services.StudentService;

import java.util.List;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Getter
public class StudentController
{
	private final StudentService studentService;

	@GetMapping
	public List<Student> getStudents()
	{
		return getStudentService().getStudents();
	}

	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable("studentId") Long studentId)
	{
		return getStudentService().getStudentById(studentId);
	}

	@GetMapping("/email/{studentEmail}")
	public Student getStudentByEmail(@PathVariable("studentEmail") String studentEmail)
	{
		return getStudentService().getStudentByEmail(studentEmail);
	}

	@GetMapping("/government/{governmentId}")
	public Student getStudentByGovernmentId(@PathVariable("governmentId") Long governmentId)
	{
		return getStudentService().getStudentByGovernmentId(governmentId);
	}

	@PostMapping
	public Student saveStudent(@Valid @RequestBody Student student)
	{
		return getStudentService().saveStudent(student);
	}

	@DeleteMapping("/{studentId}")
	public void removeStudent(@PathVariable("studentId") Long studentId)
	{
		getStudentService().removeStudent(studentId);
	}

	@DeleteMapping("/government/{governmentId}")
	public void removeStudentByGovernmentId(@PathVariable("governmentId") Long governmentId)
	{
		getStudentService().removeStudentByGovernmentId(governmentId);
	}
}
