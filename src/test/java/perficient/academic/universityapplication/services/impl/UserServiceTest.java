package perficient.academic.universityapplication.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perficient.academic.universityapplication.models.User;
import perficient.academic.universityapplication.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest
{
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	void shouldReturnEmptyList()
	{
		assertEquals(Collections.emptyList(), userService.getUsers());
	}

	@Test
	void shouldReturnUserList()
	{
		List<User> userList = new ArrayList<>();
		userList.add(new User(1234L, "test", "test@test.com", 123123L));
		userList.add(new User(12345L, "test2", "test2@test.com", 123123L));
		when(userRepository.findAll()).thenReturn(userList);
		assertEquals(userList, userService.getUsers());
	}

	@Test
	void shouldReturnUserWithId()
	{
		User user1 = new User(1234L, "Carlos", "carlos@carlos.com", 123123L);
		when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
		assertEquals(user1, userService.getUserById(user1.getId()));
	}

	@Test
	void shouldReturnExceptionById()
	{
		Throwable exception = assertThrows(NoSuchElementException.class, () -> userService.getUserById(123L));
		assertEquals("No such user with id 123", exception.getMessage());
	}

	@Test
	void shouldReturnUserWithEmail()
	{
		User user1 = new User(1234L, "Carlos", "carlos@carlos.com", 123123L);
		when(userRepository.findUserByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(user1, userService.getUserByEmail(user1.getEmail()));
	}

	@Test
	void shouldSaveUser()
	{
		User user1 = new User(1234L, "Carlos", "carlos@carlos.com", 123123L);
		when(userRepository.save(user1)).thenReturn(user1);
		assertEquals(user1, userService.saveUser(user1));
	}

	@Test
	void shouldRemoveUser(){
		User user1 = new User(1234L, "Carlos", "carlos@carlos.com", 123123L);
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		when(userRepository.findAll()).thenReturn(userList);
		assertEquals(userList, userService.getUsers());
		userService.removeUser(user1.getId());
		assertEquals(userList, userService.getUsers());
	}
}
