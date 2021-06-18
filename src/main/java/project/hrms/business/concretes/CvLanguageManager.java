package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.hrms.business.abstracts.CvLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvLanguageDao;
import project.hrms.entities.concretes.CvLanguage;
import project.hrms.entities.dtos.AdvertisementWithEmployerDto;
import project.hrms.entities.dtos.CvLanguageWithCvDto;

@Service
public class CvLanguageManager implements CvLanguageService{
	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language added.");
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {

		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll(),"Language found");
	}

	@Override
	public DataResult<CvLanguage> getByCvLanguageId(int id) {
		
		return new SuccessDataResult<CvLanguage>(this.cvLanguageDao.getByCvLanguageId(id),"found");
	}

	@Override
	public Result delete(CvLanguage cvLanguage) {
		this.cvLanguageDao.delete(cvLanguage);
		return new SuccessResult("Language deleted.");
	}

	@Override
	public Result update(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language updated.");
	}

	@Override
	public DataResult<List<CvLanguageWithCvDto>> getCvLanguageWithCvDetails(int cvId) {
		return new SuccessDataResult<List<CvLanguageWithCvDto>>(this.cvLanguageDao.getCvLanguageWithCvDetails(cvId),"Data listed");
	}
	
	
}
