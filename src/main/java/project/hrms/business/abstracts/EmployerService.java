package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.EmployerSaveDto;

public interface EmployerService {
	
	DataResult<Employer> getByEmail(String email);
	DataResult<List<Employer>> getAll();
	Result add(EmployerSaveDto employerSaveDto);
	
}
