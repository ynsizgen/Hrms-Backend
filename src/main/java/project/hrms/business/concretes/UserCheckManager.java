package project.hrms.business.concretes;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.UserCheckService;
import project.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService{
	
	@Override
	public boolean CheckIfRealPerson(User user) {
		
		return true;
	}
	
}
