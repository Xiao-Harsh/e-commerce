package com.soltrix.repository;

import com.soltrix.entity.Address;
import com.soltrix.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AddressRepository extends InMemoryRepository<Address, Long> {

    @Override
    protected Long getId(Address entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Address entity, Long id) {
        entity.setId(id);
    }

    public List<Address> findByUser(User user) {
        if (user == null || user.getId() == null) return List.of();
        return storage.values().stream()
                .filter(a -> a.getUser() != null && user.getId().equals(a.getUser().getId()))
                .collect(Collectors.toList());
    }
}
