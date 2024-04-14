package com.jitendra.catalogservice.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest( properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///db",
})
@Sql("/test-data.sql")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepo productRepo;

    // No need to test the methods provided by Spring Data JPA.
    // This test is to demonstrate how to write tests for the repository layer.

    @Test
    void shouldGetAllProducts() {
        List<ProductEntity> products = productRepo.findAll();
        assertThat(products).hasSize(15);
    }

}
