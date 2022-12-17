package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Subject;

import java.util.Optional;


public interface SubjectRepository extends JpaRepository<Subject, Long>
{
	Optional<Subject> findSubjectByName(String name);
}
