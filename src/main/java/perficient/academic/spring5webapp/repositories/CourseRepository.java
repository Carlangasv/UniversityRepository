package perficient.academic.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.academic.spring5webapp.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long>
{
	Course findCourseByName(String name);
}
