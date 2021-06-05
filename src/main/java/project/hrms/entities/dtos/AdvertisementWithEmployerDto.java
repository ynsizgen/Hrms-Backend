package project.hrms.entities.dtos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementWithEmployerDto {
	
	private int advertisementId;
	private int id;
	private String employerName;
	private String website;
	private String description;
	private boolean status;
	private Date creationDate;
  
}
