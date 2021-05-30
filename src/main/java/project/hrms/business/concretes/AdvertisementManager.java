package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;
import project.hrms.business.abstracts.AdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.AdvertisementDao;
import project.hrms.entities.concretes.Advertisement;


@Service
public class AdvertisementManager implements AdvertisementService{
	
	private AdvertisementDao advertisementDao;

	@Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(Advertisement advertisement) {
		this.advertisementDao.save(advertisement);
		return new SuccessResult("Advertisement added.");
	}
	@Override
	public DataResult<List<Advertisement>> getAll() {
		
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findAll(), "Employerlar listelendi");
	}
	
	@Override
	public DataResult<List<Advertisement>> getByEmployerId(int employerId) {
		
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByEmployerId(employerId),"Data listelendi");
	}

	@Override
	public Result changeStatus(int id, boolean status) {
		Advertisement newAdvertisement = this.advertisementDao.findById(id).orElse(null);
		newAdvertisement.setStatus(status);
		this.advertisementDao.save(newAdvertisement);
		return new SuccessResult("status of advertisement setted");
	}

	@Override
	public DataResult<List<Advertisement>> getByStatusTrue(){
		
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByStatusTrue(), "Advertisement listed");
	}

	@Override
	public DataResult<List<Advertisement>> getByStatusTrueOrderByCreationDate() {
		return new SuccessDataResult<List<Advertisement>>(advertisementDao.getByStatusTrueOrderByCreationDate());
	}

	@Override
	public DataResult<List<Advertisement>> getByStatusTrueAndEmployerId(int employerId) {
		
		return new SuccessDataResult<List<Advertisement>>(advertisementDao.getByStatusTrueAndEmployerId(employerId));
	}

	@Override
	public Result getByIdAndEmployerId(int id, int employerId) {
		Advertisement newAdvertisement = this.advertisementDao.getByIdAndEmployerId(id, employerId);
		
		newAdvertisement.setStatus(false);
		this.advertisementDao.save(newAdvertisement);
		return new SuccessResult("advertisement made inactive");  
				
}
	

	


	
	

}
