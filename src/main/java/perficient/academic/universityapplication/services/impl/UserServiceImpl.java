package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.User;
import perficient.academic.universityapplication.repositories.UserRepository;
import perficient.academic.universityapplication.services.UserService;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
@Getter
public class UserServiceImpl implements UserService
{
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	@Override
	public List<User> getUsers()
	{
		return getUserRepository().findAll();
	}

	@Override
	public User getUserById(Long userId)
	{
		return getUserRepository().findById(userId).orElseThrow(() -> new NoSuchElementException("No such user with id " + userId));
	}

	@Override
	public User getUserByEmail(String email)
	{
		return getUserRepository().findUserByEmail(email);
	}

	@Override
	public User saveUser(User newUser)
	{
		return getUserRepository().save(newUser);
	}

	@Override
	public void removeUser(Long userId)
	{
		getUserRepository().deleteById(userId);
	}
}
