package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Employer;

public interface EmployorDao extends JpaRepository<Employer, Integer>{

}
