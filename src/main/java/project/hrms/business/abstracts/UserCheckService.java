package project.hrms.business.abstracts;

import project.hrms.entities.concretes.User;

public interface UserCheckService {
	boolean CheckIfRealPerson(User user);
}
