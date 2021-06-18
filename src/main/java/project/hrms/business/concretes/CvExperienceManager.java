package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvExperienceDao;
import project.hrms.entities.concretes.CvExperience;



@Service
public class CvExperienceManager implements CvExperienceService{

	private CvExperienceDao cvExperienceDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		this.cvExperienceDao=cvExperienceDao;
	}
	
	@Override
	public DataResult<List<CvExperience>> getAllByOrderByFinishingDateDesc() {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByOrderByFinishingDateDesc(),"Data listed");
	}

	@Override
	public Result add(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);

		return new SuccessResult("Experience added");
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll(),"Experience listed"); 
	}

	@Override
	public DataResult<CvExperience> getByCvExperienceId(int id) {
		return new SuccessDataResult<CvExperience>(this.cvExperienceDao.getByCvExperienceId(id));
	}

	@Override
	public Result delete(CvExperience cvExperience) {
		this.cvExperienceDao.delete(cvExperience);
		return new SuccessResult("Experience deleted");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Experience updated");
	}

}
