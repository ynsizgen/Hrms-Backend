package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.business.abstracts.VerificationService;
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
	private VerificationService verificationService;
	private FakeCheckService fakeCheckService;

	@Autowired
	public SeekerManager(SeekerDao seekerDao, MernisCheckService mernisCheckService,
			VerificationService verificationService, FakeCheckService fakeCheckService) {
		super();
		this.seekerDao = seekerDao;
		this.mernisCheckService = mernisCheckService;
		this.verificationService = verificationService;
		this.fakeCheckService = fakeCheckService;
	}

	@Override
	public Result add(Seeker seeker) {

		DataResult<List<Seeker>> seekers = getAll();
		List<Seeker> allSeekers = seekers.getData();
		
		if (!verificationService.isNationalityIdUnique(seeker, allSeekers)) {
			return new ErrorResult("Tckno kullanılıyor");
		}else if (!verificationService.isEmailUnique(seeker, allSeekers)) {
			return new ErrorResult("Bu Email kullanılıyor");
		} else {
			if (verificationService.passwordCheck(seeker) && verificationService.inputsCheck(seeker)) {
				if (mernisCheckService.userCheck(seeker)) {
					this.seekerDao.save(seeker);
					return new SuccessResult("Seeker eklendi.");
				} else {
					return new ErrorResult("Mernis onaylamadı.");
				}
			} else {
				return new ErrorResult("Şifre en az 6 haneli olmalı. Ad soyad en az 2 haneli olmalı");
			}
		}

		/*
		 * if (!verificationService.isEmailUnique(seeker, allSeekers)) { return new
		 * ErrorResult("Bu Email kullanılıyor"); } else {
		 * 
		 * if (verificationService.passwordCheck(seeker) &&
		 * verificationService.inputsCheck(seeker)) { if
		 * (fakeCheckService.userCheck(seeker)) { this.seekerDao.save(seeker); return
		 * new SuccessResult("Ürün eklendi."); } else { return new
		 * ErrorResult("Mernis onaylamadı."); } } else { return new
		 * ErrorResult("Şifre en az 6 haneli olmalı. Ad soyad en az 2 haneli olmalı. ");
		 * } }
		 */
	}

	@Override
	public List<Seeker> addAllSeekers(List<Seeker> seekers) {
		return seekerDao.saveAll(seekers);
	}

	@Override
	public DataResult<List<Seeker>> getAll() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(), "Data listelendi");
	}

}
