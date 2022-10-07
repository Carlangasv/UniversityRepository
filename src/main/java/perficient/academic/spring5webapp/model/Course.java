package perficient.academic.spring5webapp.model;


import jakarta.persistence.*;


@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	public Course()
	{
	}

	public Course(String name)
	{
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Course course = (Course) o;

		return id.equals(course.id);
	}

	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

	@Override
	public String toString()
	{
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
