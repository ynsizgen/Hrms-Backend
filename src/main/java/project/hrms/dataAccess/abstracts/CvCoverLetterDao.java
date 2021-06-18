package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CvCoverLetter;


public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer> {
	CvCoverLetter getByCvCoverLetterId(int id);
}
