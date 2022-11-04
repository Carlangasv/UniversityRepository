package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.User;


public interface UserRepository extends JpaRepository<User, Long>
{
	User findUserByEmail(String email);
}

