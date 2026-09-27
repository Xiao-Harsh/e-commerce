package com.soltrix.repository;

import com.soltrix.entity.CartItem;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemRepository extends InMemoryRepository<CartItem, Long> {

    @Override
    protected Long getId(CartItem entity) {
        return entity.getId();
    }

    @Override
    protected void setId(CartItem entity, Long id) {
        entity.setId(id);
    }
}
