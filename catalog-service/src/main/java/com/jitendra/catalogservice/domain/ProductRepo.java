package com.jitendra.catalogservice.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);
}
