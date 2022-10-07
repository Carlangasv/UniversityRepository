package perficient.academic.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perficient.academic.spring5webapp.model.Course;
import perficient.academic.spring5webapp.repositories.CourseRepository;


@Component
public class BootStrapData implements CommandLineRunner
{
	private final CourseRepository courseRepository;

	public BootStrapData(CourseRepository courseRepository)
	{
		this.courseRepository = courseRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		Course math = new Course("Mathematics");
		Course english = new Course("English");
		courseRepository.save(math);
		courseRepository.save(english);
	}
}
