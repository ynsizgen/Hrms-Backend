package project.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementSaveDto {
	
	private String employerName;
	private int advertisementId;
	private String description;
	private double minSalary;
	private double maxSalary;
	private int amountOfPositions;
	private LocalDate deadline;
	private boolean status;
	private Date creationDate;
}
