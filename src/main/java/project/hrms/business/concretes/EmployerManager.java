package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.EmployerVerificationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;

import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmployerVerificationService employerVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerVerificationService employerVerificationService) {
		this.employerDao=employerDao;
		this.employerVerificationService=employerVerificationService;
	}
	
	
	
//	@Override
//	public Result add(EmployerSaveDto employerSaveDto) {
//		
//		Employer employer = new Employer();
//		
//		employer.setEmail(employerSaveDto.getEmail());
//		employer.setPassword(employerSaveDto.getPassword());
//		employer.setEmployerName(employerSaveDto.getEmployerName());
//		employer.setWebsite(employerSaveDto.getWebsite());
//		
//		this.employerDao.save(employer);
//		
//		return new SuccessResult("Employer added");
//	}
	
	
	@Override
	public Result add(Employer employer) {
		
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0 ) {
			 return new ErrorResult("Email is already in use!");
		}	 
		else if(!employerVerificationService.isDomainsTrue(employer)) {
			return new ErrorResult("Email and website must match");
			
		}else {
			employerDao.save(employer);
			return new SuccessResult("Employer added.");
		}
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employerlar listelendi");
	}
	
	@Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email),"Kullanıcı bulundu");
    }

}
