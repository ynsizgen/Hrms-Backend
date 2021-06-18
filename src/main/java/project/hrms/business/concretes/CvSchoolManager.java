package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvSchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvSchoolDao;
import project.hrms.entities.concretes.CvSchool;

@Service
public class CvSchoolManager implements CvSchoolService{
	private CvSchoolDao cvSchoolDao;
	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		this.cvSchoolDao=cvSchoolDao;
	}
	
	@Override
	public DataResult<List<CvSchool>> getAllByOrderByCompletionDateDesc() {
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByOrderByCompletionDateDesc(),"Data listed");
	}

	@Override
	public Result add(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("School added.");
	}

	@Override
	public DataResult<List<CvSchool>> getAll() {
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.findAll(),"School found.");
	}

	@Override
	public DataResult<CvSchool> getByCvSchoolId(int id) {
		
		return new SuccessDataResult<CvSchool>(this.cvSchoolDao.getByCvSchoolId(id));
	}

	@Override
	public Result delete(CvSchool cvSchool) {
		this.cvSchoolDao.delete(cvSchool);
		return new SuccessResult("School deleted.");
	}

	@Override
	public Result update(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("School updated.");
	}
	
	
}
