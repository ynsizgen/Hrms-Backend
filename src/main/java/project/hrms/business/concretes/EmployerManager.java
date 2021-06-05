package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.EmployerVerificationService;
import project.hrms.business.abstracts.MainVerificationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.AdvertisementDao;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.EmployerSaveDto;

@Service
public class EmployerManager implements EmployerService{
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private EmployerVerificationService employerVerificationService;
	@Autowired
	private MainVerificationService mainVerificationService;
	
	
	
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
			 return new ErrorResult("email is using!");
			 
		 }else if(!mainVerificationService.passwordCheck(employer)) {
			return new ErrorResult("Şifre en az 6 karakter olmalı");
			
		}else if(!mainVerificationService.isEmailValid(employer)) {
			return new ErrorResult("Bu Email formatı hatalı");
			
		}else if(!employerVerificationService.isNameValid(employer)){
			return new ErrorResult("Firma adı en az 5 karakterden oluşmalı");
			
		}else if(!employerVerificationService.isDomainsTrue(employer)) {
			return new ErrorResult("Email ile websitesi aynı domaine sahip olmalı");
			
		}else {
			mainVerificationService.verifyEmail(employer);
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
