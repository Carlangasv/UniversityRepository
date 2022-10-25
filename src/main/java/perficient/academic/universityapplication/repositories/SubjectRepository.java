package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Long>
{
	Subject findSubjectByName(String name);
}
