package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.repositories.SubjectRepository;
import perficient.academic.universityapplication.services.CourseService;
import perficient.academic.universityapplication.services.SubjectService;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
@Getter
class SubjectServiceImpl implements SubjectService
{
	private final ModelMapper modelMapper;
	private final SubjectRepository subjectRepository;
	private final CourseService courseService;

	@Override
	public List<Subject> getSubjects()
	{
		return getSubjectRepository().findAll();
	}

	@Override
	public Subject getSubjectById(Long subjectId)
	{
		return getSubjectRepository().findById(subjectId)
				.orElseThrow(() -> new NoSuchElementException("No such subject with id " + subjectId));
	}

	@Override
	public Subject getSubjectByName(String subjectName)
	{
		return getSubjectRepository().findSubjectByName(subjectName)
				.orElseThrow(() -> new NoSuchElementException("No such subject with name " + subjectName));
	}

	@Override
	public Subject saveSubject(Subject newSubject)
	{
		return getSubjectRepository().save(newSubject);
	}

	@Override
	public void removeSubject(Long subjectId)
	{
		getSubjectRepository().deleteById(subjectId);
	}

	@Override
	public Subject updateSubjectById(Long subjectId, Subject updatedSubject)
	{
		Subject subject = getSubjectById(subjectId);
		subject.setName(updatedSubject.getName());
		subject.setCourse(updatedSubject.getCourse());
		subject.setTeacher(updatedSubject.getTeacher());
		saveSubject(subject);
		return subject;
	}

	public boolean checkIfCourseExist(Course course)
	{
		return courseService.getCourseById(course.getId()) != null;
	}
}
