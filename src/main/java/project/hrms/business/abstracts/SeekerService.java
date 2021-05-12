package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.Seeker;

public interface SeekerService {
    Seeker addSeeker(Seeker seeker);
    List<Seeker> addAllSeekers(List<Seeker> seekers);
}
