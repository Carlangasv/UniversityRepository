package perficient.academic.universityapplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import perficient.academic.universityapplication.mappers.StudentMapper;
import perficient.academic.universityapplication.models.Student;
import perficient.academic.universityapplication.services.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


class StudentControllerTest
{
	@Mock
	private StudentService studentService;

	@Mock
	private StudentMapper studentMapper;

	private MockMvc mockMvc;

	static final String ROUTE = "/students";

	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		StudentController controller = new StudentController(studentService, studentMapper);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void getAllStudentsShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(get(ROUTE).contentType(MediaType.APPLICATION_JSON)).andReturn();
		verify(studentService, Mockito.times(1)).getStudents();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void getStudentByIdShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(get(ROUTE + "/123").contentType(MediaType.APPLICATION_JSON)).andReturn();
		verify(studentService, Mockito.times(1)).getStudentById(123L);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void getStudentByGovernmentIdShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(get(ROUTE + "/government/123").contentType(MediaType.APPLICATION_JSON)).andReturn();
		verify(studentService, Mockito.times(1)).getStudentByGovernmentId(123L);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void getStudentByEmailShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(get(ROUTE + "/email/carlos@carlos.com").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(studentService, Mockito.times(1)).getStudentByEmail("carlos@carlos.com");
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void saveCourseShouldReturnOk() throws Exception
	{
		Student student = new Student(123L, "Test", "test@test.com", 12345L, "1234");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(student);

		MvcResult mvcResult = mockMvc.perform(post(ROUTE).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void deleteCourseByIdShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(delete(ROUTE + "/123").contentType(MediaType.APPLICATION_JSON)).andReturn();
		verify(studentService, Mockito.times(1)).removeStudent(123L);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}
}
