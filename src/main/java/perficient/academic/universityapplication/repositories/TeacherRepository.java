package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
}
