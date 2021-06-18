package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.dtos.AdvertisementWithEmployerDto;


public interface AdvertisementService {
	Result add(Advertisement advertisement);
	Result update(Advertisement advertisement);
	Result delete(Advertisement advertisement);
	DataResult<List<Advertisement>> getAll();
	Result changeStatus(int id, boolean status);
	
	DataResult<List<Advertisement>> getByStatusTrue();
	DataResult<List<Advertisement>> getByEmployerId(int employerId);
	DataResult<List<Advertisement>> getByStatusTrueOrderByCreationDate();
	DataResult<List<Advertisement>> getByStatusTrueAndEmployerId(int employerId);
	
	Result getByAdvertisementIdAndEmployerId(int advertisementId ,int employerId);
	
	DataResult<List<AdvertisementWithEmployerDto>> getAdvertisementWithEmployerDetails();
	
	
}
