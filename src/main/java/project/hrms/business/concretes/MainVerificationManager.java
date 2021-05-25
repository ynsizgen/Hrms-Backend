package project.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.MainVerificationService;
import project.hrms.entities.concretes.User;


@Service
public class MainVerificationManager implements MainVerificationService{
	
	@Override
	public void verifyEmail(User user) {
		user.setVerified(true);
	}

	@Override
	public boolean passwordCheck(User user) {
		if (user.getPassword().length()>5)
			return true;
		else
			return false;
	}
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public boolean isEmailValid(User user){
		
        Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);

        if(pattern.matcher(user.getEmail()).find()) {
            return true;
        }else {
        	return false;
        }
    }
}
