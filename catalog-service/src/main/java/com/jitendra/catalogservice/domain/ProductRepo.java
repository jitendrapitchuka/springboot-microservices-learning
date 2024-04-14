package com.jitendra.catalogservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

 interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
