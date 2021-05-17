package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.Employer;

public interface EmployerService {
	Employer addEmployer(Employer employer);
	List<Employer> addAllEmployers(List<Employer> employers);
	List<Employer> getAll();
}
