package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.entities.concretes.Cv;
import project.hrms.entities.dtos.CvWithSeekerDto;


public interface CvDao extends JpaRepository<Cv, Integer>{
	
	List<Cv> getBySeekerId(int seekerId);
	
	@Query("Select new project.hrms.entities.dtos.CvWithSeekerDto"
			+ "(s.id, c.cvId) "
			+ "From Seeker s Inner Join s.cvs c")

	List<CvWithSeekerDto> getCvWithSeekerDetails();
	
	Cv getByCvId(int cvId);
	
	
	
	
}
