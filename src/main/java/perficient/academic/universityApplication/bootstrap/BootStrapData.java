package perficient.academic.universityApplication.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perficient.academic.universityApplication.model.Course;
import perficient.academic.universityApplication.model.Subject;
import perficient.academic.universityApplication.repositories.CourseRepository;
import perficient.academic.universityApplication.repositories.SubjectRepository;

import java.util.Arrays;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner
{
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;
	@Override
	public void run(String... args)
	{

		Subject subject1 = new Subject("Subject 1");
		subjectRepository.save(subject1);
		Subject subject2 = new Subject("Subject 2");
		subjectRepository.save(subject2);
		Subject subject3 = new Subject("Subject 3");
		subjectRepository.save(subject3);
		Subject subject4 = new Subject("Subject 4");
		subjectRepository.save(subject4);
		Course math = new Course("Mathematics");
		Course english = new Course("English");
		math.setSubjectList(Arrays.asList(subject2,subject3));
		english.setSubjectList(Arrays.asList(subject1,subject4));
		courseRepository.save(math);
		courseRepository.save(english);




	}
}
