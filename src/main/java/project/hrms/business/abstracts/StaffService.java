package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Staff;

public interface StaffService {
	Result add(Staff staff);
	DataResult<List<Staff>> getAll();

}
