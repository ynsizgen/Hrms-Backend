package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.SeekerService;
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
	private FakeCheckService fakeCheckService;
	

	@Autowired
	public SeekerManager(SeekerDao seekerDao, MernisCheckService mernisCheckService,
			 FakeCheckService fakeCheckService ) {
		super();
		this.seekerDao = seekerDao;
		this.mernisCheckService = mernisCheckService;
		this.fakeCheckService = fakeCheckService;
		
	}

	@Override
	public Result add(Seeker seeker) {

		if (seekerDao.findAllByNationalityNumber(seeker.getNationalityNumber()).stream().count() != 0 ) {

			return new ErrorResult("Tckno is already in use!");

		} else if (seekerDao.findAllByEmail(seeker.getEmail()).stream().count() != 0 ) {

			return new ErrorResult("Email is already in use!");

			//mernis fake or real
		}else if (!fakeCheckService.userCheck(seeker)) {
			
			return new ErrorResult("Mernis did not confirm.");
			
		} else {
			
			this.seekerDao.save(seeker);
			return new SuccessResult("Seeker added.");	
		}

	}

	@Override
	public DataResult<List<Seeker>> getAll() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(), "Seeker listed");
	}

	@Override
	public DataResult<Seeker> getById(int id) {
		return new SuccessDataResult<Seeker>(this.seekerDao.getById(id));
	
	}


}
