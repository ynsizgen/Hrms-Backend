package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.entities.concretes.CvLanguage;

import project.hrms.entities.dtos.CvLanguageWithCvDto;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	CvLanguage getByCvLanguageId(int id);
	
	@Query("Select new project.hrms.entities.dtos.CvLanguageWithCvDto"
			+ "(c.cvId, l.cvLanguageId, l.cvLanguageLevel, l.cvLanguageName) "
			+ "From Cv c Inner Join c.cvLanguages l Where c.cvId=:cvId")
 	List<CvLanguageWithCvDto> getCvLanguageWithCvDetails(int cvId);
	
	
}
