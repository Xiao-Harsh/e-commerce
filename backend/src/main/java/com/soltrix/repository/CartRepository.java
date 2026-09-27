package com.soltrix.repository;

import com.soltrix.entity.Cart;
import com.soltrix.entity.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class CartRepository extends InMemoryRepository<Cart, Long> {

    @Override
    protected Long getId(Cart entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Cart entity, Long id) {
        entity.setId(id);
    }

    public Optional<Cart> findByUser(User user) {
        if (user == null || user.getId() == null) return Optional.empty();
        return findByUserId(user.getId());
    }

    public Optional<Cart> findByUserId(Long userId) {
        if (userId == null) return Optional.empty();
        return storage.values().stream()
                .filter(c -> c.getUser() != null && userId.equals(c.getUser().getId()))
                .findFirst();
    }
}
