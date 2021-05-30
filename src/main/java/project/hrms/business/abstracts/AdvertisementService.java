package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;


public interface AdvertisementService {
	Result add(Advertisement advertisement);
	DataResult<List<Advertisement>> getAll();
	Result changeStatus(int id, boolean status);
	
	DataResult<List<Advertisement>> getByStatusTrue();
	DataResult<List<Advertisement>> getByEmployerId(int employerId);
	DataResult<List<Advertisement>> getByStatusTrueOrderByCreationDate();
	DataResult<List<Advertisement>> getByStatusTrueAndEmployerId(int employerId);
	
	Result getByIdAndEmployerId(int id ,int employerId);
}
