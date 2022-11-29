package perficient.academic.universityapplication.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perficient.academic.universityapplication.models.Teacher;
import perficient.academic.universityapplication.services.TeacherService;

import java.util.List;


@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
@Getter
public class TeacherController
{
	private final TeacherService teacherService;

	@GetMapping
	public List<Teacher> getTeachers()
	{
		return getTeacherService().getTeachers();
	}

	@GetMapping("/{teacherId}")
	public Teacher getTeacherById(@PathVariable("teacherId") Long teacherId)
	{
		return getTeacherService().getTeacherById(teacherId);
	}

	@GetMapping("/government/{governmentId}")
	public Teacher getTeacherByGovernmentId(@PathVariable("governmentId") Long governmentId)
	{
		return getTeacherService().getTeacherByGovernmentId(governmentId);
	}

	@GetMapping("/email/{teacherEmail}")
	public Teacher getTeacherByEmail(@PathVariable("teacherEmail") String teacherEmail)
	{
		return getTeacherService().getTeacherByEmail(teacherEmail);
	}

	@PostMapping
	public Teacher saveTeacher(@Valid @RequestBody Teacher newTeacher)
	{
		return getTeacherService().saveTeacher(newTeacher);
	}

	@DeleteMapping("/{teacherId}")
	public void removeTeacher(@PathVariable("teacherId") Long teacherId)
	{
		getTeacherService().removeTeacher(teacherId);
	}

	@DeleteMapping("/government/{governmentId}")
	public void removeTeacherByGovernemtId(@PathVariable("governmentId") Long governmentId)
	{
		getTeacherService().removeTeacherByGovernmentId(governmentId);
	}
}
