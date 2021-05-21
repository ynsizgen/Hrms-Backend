package project.hrms.business.concretes;

import project.hrms.business.abstracts.VerificationService;
import project.hrms.entities.concretes.User;

public class VerificationManager implements VerificationService {
	
	

	@Override
	public boolean passwordCheck(User user) {
		
		if (user.getPassword().length()>5)
			return true;
		else
			return false;
	}

	
	@Override
    public boolean inputsCheck(User user) {
        if(user.equals(user) ) {
            return true;
        }else {
            System.out.println("Ad en az 2 karakterden oluşmalıdır!");
            System.out.println("Soyad en az 2 karakterden oluşmalıdır!");
            
            return false;
        }
    }




	@Override
	public boolean emailCheck(User user) {
		
		return false;
	}
	
}
