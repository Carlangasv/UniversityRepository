package perficient.academic.universityapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subjects")
public class Subject
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Subject(String name)
	{
		this.name = name;
	}
}
