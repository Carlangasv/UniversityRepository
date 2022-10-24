package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long>
{
	Course findCourseByName(String name);
}
