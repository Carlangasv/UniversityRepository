package perficient.academic.universityapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.universityapplication.models.Course;



public interface CourseRepository extends JpaRepository<Course, Long>
{
	Course findCourseByName(String name);
}
