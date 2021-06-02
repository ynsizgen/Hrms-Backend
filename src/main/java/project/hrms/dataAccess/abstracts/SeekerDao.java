package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.entities.concretes.Seeker;
import project.hrms.entities.dtos.CvWithSeekerDto;


public interface SeekerDao extends JpaRepository<Seeker,Integer>  {
	List<Seeker> findAllByEmail(String email);
	List<Seeker> findAllByNationalityNumber(String nationalityNumber);
	
	
	
	
}
