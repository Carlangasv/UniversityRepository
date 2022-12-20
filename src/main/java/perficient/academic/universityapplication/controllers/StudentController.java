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
import perficient.academic.universityapplication.dtos.StudentDto;
import perficient.academic.universityapplication.mappers.StudentMapper;
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

	private final StudentMapper studentMapper;

	@GetMapping
	public List<StudentDto> getStudents()
	{
		return getStudentService().getStudents().stream().map(getStudentMapper()::studentToStudentDto).toList();
	}

	@GetMapping("/{studentId}")
	public StudentDto getStudentById(@PathVariable("studentId") Long studentId)
	{
		return getStudentMapper().studentToStudentDto(getStudentService().getStudentById(studentId));
	}

	@GetMapping("/email/{studentEmail}")
	public StudentDto getStudentByEmail(@PathVariable("studentEmail") String studentEmail)
	{
		return getStudentMapper().studentToStudentDto(getStudentService().getStudentByEmail(studentEmail));
	}

	@GetMapping("/government/{governmentId}")
	public StudentDto getStudentByGovernmentId(@PathVariable("governmentId") Long governmentId)
	{
		return getStudentMapper().studentToStudentDto(getStudentService().getStudentByGovernmentId(governmentId));
	}

	@PostMapping
	public StudentDto saveStudent(@Valid @RequestBody Student student)
	{
		return getStudentMapper().studentToStudentDto(getStudentService().saveStudent(student));
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
