package com.soltrix.repository;

import com.soltrix.entity.ProductImage;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImageRepository extends InMemoryRepository<ProductImage, Long> {

    @Override
    protected Long getId(ProductImage entity) {
        return entity.getId();
    }

    @Override
    protected void setId(ProductImage entity, Long id) {
        entity.setId(id);
    }
}
