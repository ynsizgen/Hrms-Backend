package project.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.StaffService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.StaffDao;
import project.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

    private StaffDao staffDao;

    @Autowired
    public StaffManager(StaffDao staffDao) {
    	super();
        this.staffDao = staffDao;
        
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

}
