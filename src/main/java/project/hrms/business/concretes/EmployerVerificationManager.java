package project.hrms.business.concretes;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerVerificationService;
import project.hrms.entities.concretes.Employer;

@Service
public class EmployerVerificationManager implements EmployerVerificationService{

	@Override
	public boolean isDomainsTrue(Employer employer) {

		String emailCheck = employer.getEmail().substring(employer.getEmail().indexOf('@') + 1);
		String websiteCheck = employer.getWebsite().substring(employer.getWebsite().indexOf('.') + 1);
		
		
		if(emailCheck.equals(websiteCheck))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean isNameValid(Employer employer) {
		if(employer.getEmployerName().length()>4 ) {
            return true;
        }else {
            return false;
        }
		
	}
	
}
