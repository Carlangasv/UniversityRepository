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
import perficient.academic.universityapplication.dtos.TeacherDto;
import perficient.academic.universityapplication.mappers.TeacherMapper;
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

	private final TeacherMapper teacherMapper;

	@GetMapping
	public List<TeacherDto> getTeachers()
	{
		return getTeacherService().getTeachers().stream().map(getTeacherMapper()::teacherToTeacherDto).toList();
	}

	@GetMapping("/{teacherId}")
	public TeacherDto getTeacherById(@PathVariable("teacherId") Long teacherId)
	{
		return getTeacherMapper().teacherToTeacherDto(getTeacherService().getTeacherById(teacherId));
	}

	@GetMapping("/government/{governmentId}")
	public TeacherDto getTeacherByGovernmentId(@PathVariable("governmentId") Long governmentId)
	{
		return getTeacherMapper().teacherToTeacherDto(getTeacherService().getTeacherByGovernmentId(governmentId));
	}

	@GetMapping("/email/{teacherEmail}")
	public TeacherDto getTeacherByEmail(@PathVariable("teacherEmail") String teacherEmail)
	{
		return getTeacherMapper().teacherToTeacherDto(getTeacherService().getTeacherByEmail(teacherEmail));
	}

	@PostMapping
	public TeacherDto saveTeacher(@Valid @RequestBody Teacher newTeacher)
	{
		return getTeacherMapper().teacherToTeacherDto(getTeacherService().saveTeacher(newTeacher));
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
