package project.hrms.business.abstracts;

import project.hrms.entities.concretes.User;

public interface MainVerificationService {
	
	public void verifyEmail(User user);
	boolean passwordCheck(User user);
	boolean isEmailValid(User user);
	
}
