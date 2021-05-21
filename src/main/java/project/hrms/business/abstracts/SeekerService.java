package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import project.hrms.entities.concretes.Seeker;

public interface SeekerService {
	ResponseEntity<?> add(Seeker seeker);
    List<Seeker> addAllSeekers(List<Seeker> seekers);
}
