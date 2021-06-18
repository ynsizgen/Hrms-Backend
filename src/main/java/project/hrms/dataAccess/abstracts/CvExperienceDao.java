package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer>{
	List<CvExperience> getAllByOrderByFinishingDateDesc();
	CvExperience getByCvExperienceId(int id);
}
