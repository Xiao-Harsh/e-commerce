package com.soltrix.repository;

import com.soltrix.entity.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UserRepository extends InMemoryRepository<User, Long> {

    @Override
    protected Long getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Long id) {
        entity.setId(id);
    }

    public Optional<User> findByEmail(String email) {
        if (email == null) return Optional.empty();
        return storage.values().stream()
                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
                .findFirst();
    }

    public Boolean existsByEmail(String email) {
        if (email == null) return false;
        return storage.values().stream()
                .anyMatch(u -> email.equalsIgnoreCase(u.getEmail()));
    }
}
