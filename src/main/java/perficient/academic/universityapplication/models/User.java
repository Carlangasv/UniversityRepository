package perficient.academic.universityapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "my_user", uniqueConstraints = @UniqueConstraint(columnNames = { "governmentId", "email" }))
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Government id must not be null")
	private Long governmentId;

	private String name;

	@NotNull(message = "Email must not be null")
	@Email
	private String email;

	@NotNull(message = "Phone must not be null")
	private Long phone;

	@NotNull(message = "Password must not be null")
	private String password;

	public User(Long governmentId, String name, String email, Long phone, String password)
	{
		this.governmentId = governmentId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
}
