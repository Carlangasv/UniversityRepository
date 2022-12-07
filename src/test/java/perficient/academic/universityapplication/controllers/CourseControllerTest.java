package perficient.academic.universityapplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import perficient.academic.universityapplication.mappers.CourseMapper;
import perficient.academic.universityapplication.models.Course;
import perficient.academic.universityapplication.services.CourseService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CourseController.class)
class CourseControllerTest
{
	@MockBean
	private CourseService courseService;

	@MockBean
	private CourseMapper courseMapper;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getAllCourses() throws Exception
	{
		Course course = new Course("Maths1");
		when(courseService.getCourses()).thenReturn(List.of(course));

		mockMvc.perform(get("/courses").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
