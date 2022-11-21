package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.Student;
import perficient.academic.universityapplication.repositories.StudentRepository;
import perficient.academic.universityapplication.services.StudentService;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
@Getter
public class StudentServiceImpl implements StudentService
{

	private final StudentRepository studentRepository;

	@Override
	public List<Student> getStudents()
	{
		return getStudentRepository().findAll();
	}

	@Override
	public Student getStudentById(Long studentId)
	{
		return getStudentRepository().findById(studentId)
				.orElseThrow(() -> new NoSuchElementException("No such student with id " + studentId));
	}

	@Override
	public Student getStudentByGovernmentId(Long governmentId)
	{
		return getStudentRepository().getStudentByGovernmentId(governmentId);
	}

	@Override
	public Student getStudentByEmail(String email)
	{
		return getStudentRepository().getStudentByEmail(email);
	}

	@Override
	public Student saveStudent(Student newStudent)
	{
		return getStudentRepository().save(newStudent);
	}

	@Override
	public void removeStudent(Long studentId)
	{
		getStudentRepository().deleteById(studentId);
	}

	@Override
	public void removeStudentByGovernmentId(Long governmentId)
	{
		getStudentRepository().removeByGovernmentId(governmentId);
	}
}
