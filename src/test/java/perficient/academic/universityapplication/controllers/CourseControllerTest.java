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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import perficient.academic.universityapplication.mappers.CourseMapper;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.services.CourseService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


class CourseControllerTest
{
	@Mock
	private CourseService courseService;

	@Mock
	private CourseMapper courseMapper;

	private MockMvc mockMvc;

	static final String ROUTE = "/courses";

	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		CourseController controller = new CourseController(courseService, courseMapper);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void getAllCoursesShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(ROUTE).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(courseService, Mockito.times(1)).getCourses();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void getCourseByIdShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(ROUTE + "/123").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(courseService, Mockito.times(1)).getCourseById(123L);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void getCourseByNameShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(
						MockMvcRequestBuilders.get(ROUTE + "/name/english1").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(courseService, Mockito.times(1)).getCourseByName("english1");
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void saveCourseShouldReturnOk() throws Exception
	{
		Course course = new Course("Mathematics");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(course);

		MvcResult mvcResult = mockMvc.perform(post(ROUTE).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void deleteCourseShouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(ROUTE + "/123").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(courseService, Mockito.times(1)).removeCourse(123L);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}
}
