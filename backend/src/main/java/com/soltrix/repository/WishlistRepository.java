package com.soltrix.repository;

import com.soltrix.entity.WishlistItem;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class WishlistRepository extends InMemoryRepository<WishlistItem, Long> {

    @Override
    protected Long getId(WishlistItem entity) {
        return entity.getId();
    }

    @Override
    protected void setId(WishlistItem entity, Long id) {
        entity.setId(id);
    }

    public List<WishlistItem> findByUserId(Long userId) {
        if (userId == null) return List.of();
        return storage.values().stream()
                .filter(w -> w.getUser() != null && userId.equals(w.getUser().getId()))
                .collect(Collectors.toList());
    }

    public Optional<WishlistItem> findByUserIdAndProductId(Long userId, Long productId) {
        if (userId == null || productId == null) return Optional.empty();
        return storage.values().stream()
                .filter(w -> w.getUser() != null && userId.equals(w.getUser().getId()) &&
                             w.getProduct() != null && productId.equals(w.getProduct().getId()))
                .findFirst();
    }

    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return findByUserIdAndProductId(userId, productId).isPresent();
    }
}
