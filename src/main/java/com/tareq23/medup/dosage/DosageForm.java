package com.tareq23.medup.dosage;

import java.util.List;

import com.tareq23.medup.product.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "dosage_form")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DosageForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private String alias;
	
	
	@OneToMany(mappedBy = "dosage")
	List<ProductEntity> products;
	
}
