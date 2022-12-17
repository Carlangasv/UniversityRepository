package perficient.academic.universityapplication.controllers;

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
import perficient.academic.universityapplication.services.CourseService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


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
	void shouldReturnOk() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(ROUTE).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(courseService,Mockito.times(1)).getCourses();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}


}
