package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvCoverLetterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvCoverLetterDao;
import project.hrms.entities.concretes.CvCoverLetter;


@Service
public class CvCoverLetterManager implements CvCoverLetterService{
	
	
	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		this.cvCoverLetterDao=cvCoverLetterDao;
	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);

		return new SuccessResult("Cover letter added");
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll(),"Cover letter found.");
	}

	@Override
	public DataResult<CvCoverLetter> getByCvCoverLetterId(int id) {
		
		return new SuccessDataResult<CvCoverLetter>(this.cvCoverLetterDao.getByCvCoverLetterId(id));
	}

	@Override
	public Result update(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Cover letter updated");
	}
	
	@Override
	public Result delete(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.delete(cvCoverLetter);
		return new SuccessResult("Cover letter deleted");
	}

	

	
	
	
}
