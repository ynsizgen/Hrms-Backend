package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.MainVerificationService;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.business.abstracts.SeekerVerificationService;
import project.hrms.core.mernis.abstracts.FakeCheckService;
import project.hrms.core.mernis.abstracts.MernisCheckService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.SeekerDao;
import project.hrms.entities.concretes.Seeker;

@Service
public class SeekerManager implements SeekerService {
	private SeekerDao seekerDao;
	private MernisCheckService mernisCheckService;
	private SeekerVerificationService seekerVerificationService;
	private FakeCheckService fakeCheckService;
	private MainVerificationService mainVerificationManager;

	@Autowired
	public SeekerManager(SeekerDao seekerDao, MernisCheckService mernisCheckService, SeekerVerificationService seekerVerificationService,
			 FakeCheckService fakeCheckService, MainVerificationService mainVerificationManager ) {
		super();
		this.seekerDao = seekerDao;
		this.mernisCheckService = mernisCheckService;
		this.seekerVerificationService = seekerVerificationService;
		this.fakeCheckService = fakeCheckService;
		this.mainVerificationManager = mainVerificationManager;
	}

	@Override
	public Result add(Seeker seeker) {

		if (seekerDao.findAllByNationalityId(seeker.getNationalityId()).stream().count() != 0 ) {

			return new ErrorResult("Tckno kullanılıyor");

		} else if (seekerDao.findAllByEmail(seeker.getEmail()).stream().count() != 0 ) {

			return new ErrorResult("Bu Email kullanılıyor");

		} else if (!mainVerificationManager.isEmailValid(seeker)) {

			return new ErrorResult("Bu Email formatı hatalı");

		} else if (!mainVerificationManager.passwordCheck(seeker)) {

			return new ErrorResult("Şifre en az 6 haneli olmalı!");

		} else if (!seekerVerificationService.isNameAndSurnameValid(seeker)) {
			
			return new ErrorResult("Ad soyad en az 2 haneli olmalı.");
			
			//mernis fake or real
		}else if (!mernisCheckService.userCheck(seeker)) {
			
			return new ErrorResult("Mernis onaylamadı.");
			
		} else {
			
			this.seekerDao.save(seeker);
			return new SuccessResult("Seeker eklendi.");	
		}

	}

	@Override
	public DataResult<List<Seeker>> getAll() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(), "Data listelendi");
	}

}
