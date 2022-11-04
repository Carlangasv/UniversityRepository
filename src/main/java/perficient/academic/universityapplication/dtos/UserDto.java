package perficient.academic.universityapplication.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.academic.universityapplication.enums.UserType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private Long phone;

	@JsonProperty("userType")
	private UserType userType;
}
