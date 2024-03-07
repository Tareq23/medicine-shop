package com.tareq23.medup.generics;

import java.util.List;
import java.util.Set;

import com.tareq23.medup.address.AddressEntity;
import com.tareq23.medup.category.CategoryEntity;
import com.tareq23.medup.product.ProductEntity;
import com.tareq23.medup.roleuser.UserRoleEntity;
import com.tareq23.medup.userdetails.UserDetailsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "generics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	private String type;
	private String pregnancyCat;
	private String contraindications;
	private String dosage;
	private String modeOfAction;
	private String indicationDetails;
	private String interaction;
	private String administration;
	private String side_effects;
	private String precautions;
	private String description;
	private String reconstitution;
	private String duration_of_treatment;
	private String pediatric_uses;
	private String storage_conditions;
	private String overdose_effects;
	private String composition;
	private String status;
	
	
	
	@OneToMany(mappedBy = "generic")
	private List<ProductEntity> products;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category;
	
}
