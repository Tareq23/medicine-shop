package com.tareq23.medup.manufacturer;

import java.util.List;

import com.tareq23.medup.product.ProductController;
import com.tareq23.medup.product.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="manufacturers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String alias;
	private String slug;
	private String description;
	private String img;
	
	@OneToMany(mappedBy = "company")
	List<ProductEntity> products;
}
