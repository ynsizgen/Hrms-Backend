package project.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.StaffService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobPositionDao;
import project.hrms.dataAccess.abstracts.StaffDao;
import project.hrms.entities.concretes.JobPosition;
import project.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

    private StaffDao staffDao;
    private JobPositionDao jobPositionDao;

    @Autowired
    public StaffManager(StaffDao staffDao, JobPositionDao jobPositionDao) {
    	super();
        this.staffDao = staffDao;
        this.jobPositionDao=jobPositionDao;
    }

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Staff eklendi");
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Staff eklendi");
	}
	
}
