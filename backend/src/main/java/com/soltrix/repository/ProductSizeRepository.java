package com.soltrix.repository;

import com.soltrix.entity.ProductSize;
import org.springframework.stereotype.Repository;

@Repository
public class ProductSizeRepository extends InMemoryRepository<ProductSize, Long> {

    @Override
    protected Long getId(ProductSize entity) {
        return entity.getId();
    }

    @Override
    protected void setId(ProductSize entity, Long id) {
        entity.setId(id);
    }
}
