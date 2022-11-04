package perficient.academic.universityapplication.mappers;

import org.mapstruct.Mapper;
import perficient.academic.universityapplication.dtos.UserDto;
import perficient.academic.universityapplication.models.User;


@Mapper(componentModel = "spring")
public interface UserMapper
{
	UserDto userToUserDto(User user);
}
