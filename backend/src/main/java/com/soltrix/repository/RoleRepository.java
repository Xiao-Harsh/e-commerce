package com.soltrix.repository;

import com.soltrix.entity.RoleEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class RoleRepository extends InMemoryRepository<RoleEntity, Long> {

    @Override
    protected Long getId(RoleEntity entity) {
        return entity.getId();
    }

    @Override
    protected void setId(RoleEntity entity, Long id) {
        entity.setId(id);
    }

    public Optional<RoleEntity> findByNameIgnoreCase(String name) {
        if (name == null) return Optional.empty();
        return storage.values().stream()
                .filter(r -> name.equalsIgnoreCase(r.getName()))
                .findFirst();
    }
}
