package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.dtos.AdvertisementSaveDto;
import project.hrms.entities.dtos.AdvertisementWithEmployerDto;

import org.springframework.data.domain.Sort;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer>{
	List<Advertisement> getByEmployerId(int employerId);
	List<Advertisement> getByStatusTrue();
	List<Advertisement> getByStatusTrueOrderByCreationDate();
	List<Advertisement> getByStatusTrueAndEmployerId(int employerId);
	Advertisement getByAdvertisementIdAndEmployerId(int advertisementId ,int employerId);
	
	
	@Query("Select new project.hrms.entities.dtos.AdvertisementWithEmployerDto"
			+ "(a.id,e.id, e.employerName, e.website, a.description, a.status, a.creationDate) "
			+ "From Employer e Inner Join e.advertisements a")
 	List<AdvertisementWithEmployerDto> getAdvertisementWithEmployerDetails();

}	


