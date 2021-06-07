package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvSchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
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
	
	
}
