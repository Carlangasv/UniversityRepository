package perficient.academic.universityapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.academic.universityapplication.enums.UserType;

@Entity
@NoArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User
{
	@NotNull
	private String role = UserType.STUDENT.toString();

	public Student(Long id, String name,
			@NotNull @Email String email, @NotNull Long phone)
	{
		super(id, name, email, phone);
	}
}
