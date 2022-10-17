package perficient.academic.universityApplication.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(targetEntity = Subject.class)
	private List<Subject> subjectList;

	public Course(String name)
	{
		this.name = name;
	}
}
