package project.hrms.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLanguageWithCvDto {
	private int cvId;
	private int cvLanguageId;
	private String cvLanguageLevel;
	private String cvLanguageName;
}
