package project.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.StaffService;
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
	public List<Staff> getAll() {
		return this.staffDao.findAll();
	}
	
	public Staff addStaff(Staff staff) {
		return this.staffDao.save(staff);
	}

	@Override
	public List<Staff> addAllStaff(List<Staff> staffs) {
		return this.staffDao.saveAll(staffs);
	}



	



	
	




}
