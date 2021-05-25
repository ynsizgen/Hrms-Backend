package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Employer;

public interface EmployerVerificationService {
	boolean isDomainsTrue(Employer employer);
	boolean isNameValid(Employer employer);
}
