package perficient.academic.universityapplication.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Teacher;

@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
	Teacher getTeacherByGovernmentId(Long governmentId);

	Teacher getTeacherByEmail(String email);

	void deleteTeacherByGovernmentId(Long governmentId);
}
