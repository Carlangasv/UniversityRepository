package perficient.academic.universityapplication.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto
{
	@JsonProperty("name")
	private String name;
	@JsonProperty("subjects")
	private List<SubjectDto> subjectList;
}
