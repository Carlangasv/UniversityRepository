package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.Teacher;
import perficient.academic.universityapplication.repositories.TeacherRepository;
import perficient.academic.universityapplication.services.TeacherService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Getter
public class TeacherServiceImpl implements TeacherService
{
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getTeachers()
	{
		return getTeacherRepository().findAll();
	}

	@Override
	public Teacher getTeacherById(Long teacherId)
	{
		return getTeacherRepository().findById(teacherId)
				.orElseThrow(() -> new NoSuchElementException("No such subject with id " + teacherId));
	}

	@Override
	public Teacher getTeacherByGovernmentId(Long governmentId)
	{
		return getTeacherRepository().getTeacherByGovernmentId(governmentId);
	}

	@Override
	public Teacher getTeacherByEmail(String email)
	{
		return getTeacherRepository().getTeacherByEmail(email);
	}

	@Override
	public Teacher saveTeacher(Teacher newTeacher)
	{
		return getTeacherRepository().save(newTeacher);
	}

	@Override
	public void removeTeacher(Long teacherId)
	{
		getTeacherRepository().deleteById(teacherId);
	}

	@Override
	public void removeTeacherByGovernmentId(Long governmentId)
	{
		getTeacherRepository().removeByGovernmentId(governmentId);
	}
}
