package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;

import project.hrms.entities.concretes.Cv;

import project.hrms.entities.dtos.CvWithSeekerDto;

@Service
public class CvManager implements CvService{
	
	
	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		this.cvDao=cvDao;
	}

	
	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv added.");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cv listelendi");
	}
	
	@Override
	public DataResult<List<CvWithSeekerDto>> getCvWithSeekerDetails() {
		return new SuccessDataResult<List<CvWithSeekerDto>>(this.cvDao.getCvWithSeekerDetails(),"Data listed");
	}
	
	@Override
	public DataResult<List<Cv>> getBySeekerId(int seekerId) {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.getBySeekerId(seekerId),"Data listelendi");
	}

	@Override
	public DataResult<Cv> getByCvId(int cvId) {
		return new SuccessDataResult<Cv>(this.cvDao.getByCvId(cvId));
	}
	
	
	
}