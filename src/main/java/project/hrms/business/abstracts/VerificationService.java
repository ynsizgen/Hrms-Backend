package project.hrms.business.abstracts;

import project.hrms.entities.concretes.User;

public interface VerificationService {
	boolean passwordCheck(User user);
	boolean inputsCheck(User user);
	boolean emailCheck(User user);
}