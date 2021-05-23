package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.Seeker;
import project.hrms.entities.concretes.User;

public interface VerificationService {
	boolean passwordCheck(User user);
	boolean inputsCheck(Seeker seeker);
	boolean isEmailUnique(Seeker seeker, List<Seeker> seekers);
	boolean isNationalityIdUnique(Seeker seeker, List<Seeker> seekers);
}