package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import org.springframework.data.domain.Sort;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer>{
	List<Advertisement> getByEmployerId(int employerId);
	List<Advertisement> getByStatusTrue();
	List<Advertisement> getByStatusTrueOrderByCreationDate();
	List<Advertisement> getByStatusTrueAndEmployerId(int employerId);
	Advertisement getByIdAndEmployerId(int id ,int employerId);
 	

}
