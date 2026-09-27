package com.soltrix.repository;

import com.soltrix.entity.Category;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class CategoryRepository extends InMemoryRepository<Category, Long> {

    @Override
    protected Long getId(Category entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Category entity, Long id) {
        entity.setId(id);
    }

    public Optional<Category> findByNameIgnoreCase(String name) {
        if (name == null) return Optional.empty();
        return storage.values().stream()
                .filter(c -> name.equalsIgnoreCase(c.getName()))
                .findFirst();
    }
}
