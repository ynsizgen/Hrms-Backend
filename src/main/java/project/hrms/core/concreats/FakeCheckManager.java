package project.hrms.core.concreats;

import org.springframework.stereotype.Service;

import project.hrms.core.abstracts.FakeCheckService;

import project.hrms.entities.concretes.Seeker;

@Service
public class FakeCheckManager implements FakeCheckService{
	
	@Override
	public boolean userCheck(Seeker seeker) {
		return true;
	}
	
}
