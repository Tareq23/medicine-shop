package com.tareq23.medup.address;

import java.util.List;

import com.tareq23.medup.auth.entity.UserCredential;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="addresses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(columnDefinition = "varchar(100)")
	private String division;
	
	@Column(columnDefinition = "varchar(100)")
	private String city;
	
	private Integer wordNo;
	
	@Column(columnDefinition = "varchar(30)")
	private String zipCode;
	
	private String road;
	
	
	private String nearBy;
	
	@Column(columnDefinition = "varchar(30)")
	private String houseNo;
	
	@Column(columnDefinition = "varchar(15)")
	private String mobileNumber;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserCredential user;
}
