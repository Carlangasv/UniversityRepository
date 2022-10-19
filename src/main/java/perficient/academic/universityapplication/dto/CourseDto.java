package perficient.academic.universityapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto
{

	private Long id;
	private String name;
	private List<SubjectDto> subjectList;
}
