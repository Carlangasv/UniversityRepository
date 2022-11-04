package perficient.academic.universityapplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perficient.academic.universityapplication.dtos.UserDto;
import perficient.academic.universityapplication.mappers.UserMapper;
import perficient.academic.universityapplication.models.User;
import perficient.academic.universityapplication.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Getter
public class UserController
{
	private final UserService userService;

	private final UserMapper userMapper;

	@GetMapping
	public List<UserDto> getUsers()
	{
		return getUserService().getUsers().stream().map(getUserMapper()::userToUserDto).toList();
	}

	@GetMapping("/{userId}")
	public UserDto getUserById(@PathVariable("userId") Long userId)
	{
		return getUserMapper().userToUserDto(getUserService().getUserById(userId));
	}

	@GetMapping("/email/{userEmail}")
	public UserDto getUserByEmail(@PathVariable("userEmail") String userEmail)
	{
		return getUserMapper().userToUserDto(getUserService().getUserByEmail(userEmail));
	}

	@PostMapping
	public UserDto saveUser(@Valid @RequestBody User user)
	{
		return getUserMapper().userToUserDto(getUserService().saveUser(user));
	}

	@DeleteMapping("/{userId}")
	public void removeUser(@PathVariable("userId") Long userId)
	{
		getUserService().removeUser(userId);
	}
}
