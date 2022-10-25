package perficient.academic.universityapplication.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perficient.academic.universityapplication.models.Subject;
import perficient.academic.universityapplication.repositories.SubjectRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class SubjectServiceTest
{
	@Mock
	private SubjectRepository subjectRepository;

	@InjectMocks
	private SubjectServiceImpl subjectService;

	@Test
	void shouldReturnEmptyList()
	{
		assertEquals(Collections.emptyList(), subjectService.getSubjects());
	}

	@Test
	void shouldReturnSubjectList()
	{
		List<Subject> subjectList = new ArrayList<>();
		subjectList.add(new Subject("Subject 1"));
		subjectList.add(new Subject("Subject 2"));
		when(subjectRepository.findAll()).thenReturn(subjectList);
		assertEquals(subjectList, subjectService.getSubjects());
	}

	@Test
	void shouldReturnSubjectWithId()
	{
		Subject subject = new Subject("Subject 1");
		when(subjectRepository.findById(subject.getId())).thenReturn(Optional.of(subject));
		assertEquals(subject, subjectService.getSubjectById(subject.getId()));
	}

	@Test
	void shouldReturnExceptionById()
	{
		Throwable exception = assertThrows(NoSuchElementException.class, () -> subjectService.getSubjectById(2L));
		assertEquals("No such subject with id 2", exception.getMessage());
	}

	@Test
	void shouldReturnSubjectWithName()
	{
		Subject subject = new Subject("Subject 1");
		when(subjectRepository.findSubjectByName(subject.getName())).thenReturn(subject);
		assertEquals(subject, subjectService.getSubjectByName(subject.getName()));
	}

	@Test
	void shouldSaveSubject(){
		Subject subject = new Subject("Subject 1");
		when(subjectRepository.save(subject)).thenReturn(subject);
		assertEquals(subject, subjectService.saveSubject(subject));
	}

	@Test
	void shouldRemoveCourse(){
		Subject subject = new Subject("Subject 1");
		List<Subject> subjectList = new ArrayList<>();
		subjectList.add(subject);
		when(subjectRepository.findAll()).thenReturn(subjectList);
		assertEquals(subjectList, subjectService.getSubjects());
		subjectService.removeSubject(subject.getId());
		subjectList.remove(subject);
		assertEquals(subjectList, subjectService.getSubjects());
	}
}

