package perficient.academic.universityapplication.services;

import perficient.academic.universityapplication.models.Teacher;

import java.util.List;


public interface TeacherService
{
	List<Teacher> getTeachers();

	Teacher getTeacherById(Long teacherId);

	Teacher getTeacherByGovernmentId(Long governmentId);

	Teacher getTeacherByEmail(String email);

	Teacher saveTeacher(Teacher newTeacher);

	void removeTeacher(Long teacherId);

	void removeTeacherByGovernmentId(Long governmentId);
}
