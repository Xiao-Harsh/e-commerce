package com.soltrix.repository;

import com.soltrix.entity.Order;
import com.soltrix.entity.User;
import org.springframework.stereotype.Repository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository extends InMemoryRepository<Order, Long> {

    @Override
    protected Long getId(Order entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Order entity, Long id) {
        entity.setId(id);
    }

    public List<Order> findByUserOrderByCreatedAtDesc(User user) {
        if (user == null || user.getId() == null) return List.of();
        return storage.values().stream()
                .filter(o -> o.getUser() != null && user.getId().equals(o.getUser().getId()))
                .sorted(Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }

    public List<Order> findAllByOrderByCreatedAtDesc() {
        return storage.values().stream()
                .sorted(Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }
}
