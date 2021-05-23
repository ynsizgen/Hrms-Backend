package project.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.VerificationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Seeker;
import project.hrms.entities.concretes.User;

@Service
public class VerificationManager  implements VerificationService {
	
	

	@Override
	public boolean passwordCheck(User user) {
		if (user.getPassword().length()>5)
			return true;
		else
			return false;
	}

	@Override
    public boolean inputsCheck(Seeker seeker) {
        if(seeker.getFirstName().length()>1 && seeker.getLastName().length()>1) {
            return true;
        }else {
            return false;
        }
    }
	@Override
	public boolean isEmailUnique(Seeker seeker, List<Seeker> seekers) {
		
		for (Seeker newSeeker : seekers) {
			if(newSeeker.getEmail().equals(seeker.getEmail())) {
				return false;
			}
		}
		return true;	
	}
	
	@Override
	public boolean isNationalityIdUnique(Seeker seeker, List<Seeker> seekers) {
		
		for (Seeker newSeeker : seekers) {
			if(newSeeker.getNationalityId().equals(seeker.getNationalityId())) {
				return false;
			}
		}
		return true;	
	}
	
	 
	
}
