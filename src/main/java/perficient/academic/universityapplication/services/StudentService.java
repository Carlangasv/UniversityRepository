package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.models.Student;

import java.util.List;


public interface StudentService
{
	List<Student> getStudents();

	Student getStudentById(Long studentId);

	Student getStudentByGovernmentId(Long governmentId);

	Student getStudentByEmail(String email);

	Student saveStudent(Student newStudent);

	void removeStudent(Long studentId);

	void removeStudentByGovernmentId(Long governmentId);
}
