package project.hrms.business.abstracts;

import java.util.List;



import project.hrms.entities.concretes.Staff;

public interface StaffService {
	Staff addStaff(Staff staff);
	List<Staff> addAllStaff(List<Staff> staffs);
	List<Staff> getAll();
}
