package perficient.academic.universityapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
@Profile(value="dev")
public class UniversityApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(UniversityApplication.class, args);
	}
}
