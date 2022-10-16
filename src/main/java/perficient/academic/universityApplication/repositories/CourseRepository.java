package perficient.academic.universityApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityApplication.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long>
{
	Course findCourseByName(String name);
}
