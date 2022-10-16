package perficient.academic.universityApplication.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perficient.academic.universityApplication.model.Course;
import perficient.academic.universityApplication.model.Subject;
import perficient.academic.universityApplication.repositories.CourseRepository;
import perficient.academic.universityApplication.repositories.SubjectRepository;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner
{
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;
	@Override
	public void run(String... args)
	{
		Course math = new Course("Mathematics");
		Course english = new Course("English");
		courseRepository.save(math);
		courseRepository.save(english);

		Subject subject1 = new Subject("Subject 1");
		subjectRepository.save(subject1);
	}
}
