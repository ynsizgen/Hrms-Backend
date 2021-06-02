package project.hrms.business.abstracts;


import project.hrms.entities.concretes.Seeker;

public interface SeekerVerificationService {
	boolean isNameAndSurnameValid(Seeker seeker);
	
}