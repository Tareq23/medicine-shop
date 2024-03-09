package com.tareq23.medup.generics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericsRepository extends JpaRepository<GenericsEntity, Long> {
}
