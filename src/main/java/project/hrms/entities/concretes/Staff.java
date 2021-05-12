package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Staff")
public class Staff implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, updatable = false)
    private int id;

    @Column(name = "staff_name", nullable = false)
    private String staffName;

    @Column(name = "staff_surname", nullable = false)
    private  String staffSurname;
    
   
	public Staff() {
		super();
	}

	public Staff(int id, String staffName, String staffSurname) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffSurname = staffSurname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSurname() {
		return staffSurname;
	}

	public void setStaffSurname(String staffSurname) {
		this.staffSurname = staffSurname;
	}
    
    
}
