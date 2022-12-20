package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
	Student getStudentByEmail(String email);

	Student getStudentByGovernmentId(Long governmentId);

	void deleteByGovernmentId(Long governmentId);
}
