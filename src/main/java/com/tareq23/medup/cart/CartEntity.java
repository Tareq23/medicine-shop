package com.tareq23.medup.cart;

import com.tareq23.medup.Category.CategoryEntity;
import com.tareq23.medup.Product.ProductEntity;
import com.tareq23.medup.auth.entity.UserCredential;
import com.tareq23.medup.generics.GenericsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserCredential user;
	
	@NotBlank
	private Integer quantity;
	
}
