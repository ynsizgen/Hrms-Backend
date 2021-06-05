package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //, unique = true, updatable = false
    @Column(name = "name", length = 20)
    private String cityName;

    @JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "advertisement_id", referencedColumnName = "advertisement_id")
    private Advertisement advertisement;
}