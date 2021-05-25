package project.hrms.business.concretes;


import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.SeekerVerificationService;
import project.hrms.entities.concretes.Seeker;


@Service
public class SeekerVerificationManager  implements SeekerVerificationService {
	
	@Override
    public boolean isNameAndSurnameValid(Seeker seeker) {
        if(seeker.getFirstName().length()>1 && seeker.getLastName().length()>1) {
            return true;
        }else {
            return false;
        }
    }
	
	
}
