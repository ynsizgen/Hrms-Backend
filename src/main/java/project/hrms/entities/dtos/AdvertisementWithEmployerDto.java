package project.hrms.entities.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementWithEmployerDto {
	
	private int advertisementId;
	private String employerName;
	private String website;
	private String description;
	private boolean status;
	private LocalDate creationDate;
  
}
