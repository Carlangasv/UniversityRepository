package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
	Teacher getTeacherByGovernmentId(Long governmentId);

	Teacher getTeacherByEmail(String email);

	void removeByGovernmentId(Long governmentId);
}
