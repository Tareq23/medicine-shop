package com.tareq23.medup.product;

import java.util.List;
import java.util.Locale.Category;

import com.tareq23.medup.cart.CartEntity;
import com.tareq23.medup.category.CategoryEntity;
import com.tareq23.medup.generics.GenericsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Integer unit;
	
	private Float previousPrice;
	
	private Float currentPrice;
	
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name="generic_id", referencedColumnName = "id")
	private GenericsEntity generic;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category;
	
	
	@OneToMany(mappedBy = "product")
	private List<CartEntity> carts;

}
