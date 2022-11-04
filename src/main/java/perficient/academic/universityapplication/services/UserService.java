package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.models.User;

import java.util.List;


public interface UserService
{
	List<User> getUsers();

	User getUserById(Long userId);

	User getUserByEmail(String email);

	User saveUser(User newUser);

	void removeUser(Long userId);
}
