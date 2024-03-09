package com.tareq23.medup.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposity extends JpaRepository<ProductEntity, Long> {
}
