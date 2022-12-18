package perficient.academic.universityapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto
{

	private Long governmentId;

	private String name;

	private String email;

	private Long phone;

}
