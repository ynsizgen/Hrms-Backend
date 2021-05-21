package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.core.concreats.MernisCheckManagerAdapter;
import project.hrms.core.abstracts.MernisCheckService;
import project.hrms.core.concreats.FakeCheckManager;
import project.hrms.dataAccess.abstracts.SeekerDao;
import project.hrms.entities.concretes.Seeker;

@Service
public class SeekerManager implements SeekerService {
    private SeekerDao seekerDao;
    private MernisCheckService mernisCheckService;
    

    @Autowired
    public SeekerManager(SeekerDao seekerDao, MernisCheckService mernisCheckService ){
    	super();
        this.seekerDao=seekerDao;
        this.mernisCheckService=mernisCheckService;       
    }

    @Override
    public ResponseEntity<?> add(Seeker seeker) {
    	
    	if(mernisCheckService.userCheck(seeker)) {
    		return ResponseEntity.ok(this.seekerDao.save(seeker));
    	}else {
    		return ResponseEntity.badRequest().body("kullancı bilgileri yanlış");
    	}
		/* 
    	if(fakeCheckManager.userCheck(seeker)) {
    		return seekerDao.save(seeker);
    	}else {
    		return seeker;
    	}
		*/
    }

	@Override
	public List<Seeker> addAllSeekers(List<Seeker> seekers) {
		return seekerDao.saveAll(seekers);
	}
}
