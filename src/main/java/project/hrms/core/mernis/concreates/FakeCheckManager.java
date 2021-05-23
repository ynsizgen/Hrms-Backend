package project.hrms.core.mernis.concreates;

import org.springframework.stereotype.Service;



import project.hrms.entities.concretes.Seeker;

@Service
public class FakeCheckManager implements project.hrms.core.mernis.abstracts.FakeCheckService{
	
	@Override
	public boolean userCheck(Seeker seeker) {
		return true;
	}
	
}
