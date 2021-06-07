package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;

public interface UserService {
	Result add(User user);
    DataResult<User> findByEmail(String email);
}
