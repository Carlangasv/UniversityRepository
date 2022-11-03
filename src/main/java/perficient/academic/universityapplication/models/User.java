package perficient.academic.universityapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.academic.universityapplication.enums.UserType;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User
{
	@Id
	private Long id;

	private String name;

	private String email;

	private Long phone;

	@Enumerated(EnumType.ORDINAL)
	private UserType userType;
}
