package perficient.academic.universityapplication.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.models.Student;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.models.Teacher;
import perficient.academic.universityapplication.repositories.CourseRepository;
import perficient.academic.universityapplication.repositories.StudentRepository;
import perficient.academic.universityapplication.repositories.SubjectRepository;
import perficient.academic.universityapplication.repositories.TeacherRepository;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner
{
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;
	private final StudentRepository studentRepository;
	private final TeacherRepository teacherRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args)
	{
		createUsers();
	}

	private void createSubjectsAndCourses(Teacher teacher)
	{
		Subject subject1 = new Subject("Subject1");
		Subject subject2 = new Subject("Subject2");
		Subject subject3 = new Subject("Subject3");
		Subject subject4 = new Subject("Subject4");
		Course math = new Course("Mathematics");
		Course english = new Course("English");
		subject1.setCourse(math);
		subject1.setTeacher(teacher);
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
		Long id = Long.parseLong(System.getenv("ID"));
		String name = System.getenv("USER_NAME");
		String email = System.getenv("USER_EMAIL");
		Long phone = Long.parseLong(System.getenv("PHONE"));
		String password = System.getenv("PASSWORD");
		Long salary = 123123L;
		Student user1 = new Student(id, name, email, phone, passwordEncoder.encode(password));
		studentRepository.save(user1);

		Long id2 = 12345L;
		String name2 = "Profe";
		String email2 = "profe@profe.com";
		Teacher teacher1 = new Teacher(id2, name2, email2, phone, salary, passwordEncoder.encode(password));
		teacherRepository.save(teacher1);

		createSubjectsAndCourses(teacher1);
	}
}
