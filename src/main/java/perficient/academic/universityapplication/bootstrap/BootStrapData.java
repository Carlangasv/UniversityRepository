package perficient.academic.universityapplication.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perficient.academic.universityapplication.enums.UserType;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.models.User;
import perficient.academic.universityapplication.repositories.CourseRepository;
import perficient.academic.universityapplication.repositories.SubjectRepository;
import perficient.academic.universityapplication.repositories.UserRepository;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner
{
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;
	private final UserRepository userRepository;

	@Override
	public void run(String... args)
	{
		createSubjectsAndCourses();
		createUsers();
	}

	private void createSubjectsAndCourses()
	{
		Subject subject1 = new Subject("Subject1");
		Subject subject2 = new Subject("Subject2");
		Subject subject3 = new Subject("Subject3");
		Subject subject4 = new Subject("Subject4");
		Course math = new Course("Mathematics");
		Course english = new Course("English");
		subject1.setCourse(math);
		subject2.setCourse(math);
		subject3.setCourse(english);
		subject4.setCourse(english);
		courseRepository.save(math);
		courseRepository.save(english);
		subjectRepository.save(subject1);
		subjectRepository.save(subject2);
		subjectRepository.save(subject3);
		subjectRepository.save(subject4);
	}

	private void createUsers()
	{
		User user1 = new User(1234L, "Carlos", "carlos@carlos.com", 123123L, UserType.STUDENT);
		userRepository.save(user1);
	}
}
