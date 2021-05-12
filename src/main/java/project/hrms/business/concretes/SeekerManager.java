package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.dataAccess.abstracts.SeekerDao;
import project.hrms.entities.concretes.Seeker;

@Service
public class SeekerManager implements SeekerService {
    private SeekerDao seekerDao;

    @Autowired
    public SeekerManager(SeekerDao seekerDao){
    	super();
        this.seekerDao=seekerDao;
    }

    
    @Override
    public Seeker addSeeker(Seeker seeker) {
       return seekerDao.save(seeker);
    }

	@Override
	public List<Seeker> addAllSeekers(List<Seeker> seekers) {
		return seekerDao.saveAll(seekers);
	}
}
