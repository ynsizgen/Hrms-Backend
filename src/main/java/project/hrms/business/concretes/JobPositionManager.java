package project.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobPositionDao;
import project.hrms.entities.concretes.JobPosition;


@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public Result add(JobPosition jobPosition) {
		
		DataResult<List<JobPosition>> jobPositions = getAll();
		
		
		for (JobPosition newJobPosition : jobPositions.getData()) {
			if(newJobPosition.getJobPositionName().equals(jobPosition.getJobPositionName())) {
				return new ErrorResult(" jobPosition is already exist!");
			}
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("JobPosition added");
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "jobPosition Data listelendi");
	}

}
