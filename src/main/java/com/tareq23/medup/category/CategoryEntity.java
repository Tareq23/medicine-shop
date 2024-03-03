package com.tareq23.medup.category;

import java.util.List;
import java.util.Set;

import com.tareq23.medup.generics.GenericsEntity;
import com.tareq23.medup.product.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Lob
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products;
	
	@OneToMany(mappedBy = "category")
	private List<GenericsEntity> generics;
}
