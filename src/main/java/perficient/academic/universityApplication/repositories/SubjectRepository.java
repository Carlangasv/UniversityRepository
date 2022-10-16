package perficient.academic.universityApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityApplication.model.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Long>
{
	Subject findSubjectByName(String name);
}
