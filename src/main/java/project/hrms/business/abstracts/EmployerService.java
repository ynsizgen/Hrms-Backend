package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;


public interface EmployerService {
	
	DataResult<Employer> getById(int employerId);
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	public Result update(Employer employer);
	public Result delete(Employer employer);
    
}
