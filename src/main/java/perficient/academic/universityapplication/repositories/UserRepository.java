package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findUserByEmail(String email);
}

