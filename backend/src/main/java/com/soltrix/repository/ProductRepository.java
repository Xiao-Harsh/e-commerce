package com.soltrix.repository;

import com.soltrix.entity.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository extends InMemoryRepository<Product, Long> {

    @Override
    protected Long getId(Product entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Product entity, Long id) {
        entity.setId(id);
    }

    public List<Product> findByCategoryNameIgnoreCase(String category) {
        if (category == null || category.trim().isEmpty() || "ALL".equalsIgnoreCase(category.trim())) {
            return findAll();
        }
        return storage.values().stream()
                .filter(p -> p.getCategory() != null && category.trim().equalsIgnoreCase(p.getCategory().getName()))
                .collect(Collectors.toList());
    }

    public List<Product> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return findAll();
        }
        String q = query.toLowerCase().trim();
        return storage.values().stream()
                .filter(p -> (p.getTitle() != null && p.getTitle().toLowerCase().contains(q)) ||
                             (p.getBrand() != null && p.getBrand().toLowerCase().contains(q)) ||
                             (p.getCategory() != null && p.getCategory().getName() != null && p.getCategory().getName().toLowerCase().contains(q)))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsWithCategory(String query, String category) {
        if (category == null || category.trim().isEmpty() || "ALL".equalsIgnoreCase(category.trim())) {
            return searchProducts(query);
        }
        if (query == null || query.trim().isEmpty()) {
            return findByCategoryNameIgnoreCase(category);
        }
        String cat = category.trim();
        String q = query.toLowerCase().trim();
        return storage.values().stream()
                .filter(p -> p.getCategory() != null && cat.equalsIgnoreCase(p.getCategory().getName()))
                .filter(p -> (p.getTitle() != null && p.getTitle().toLowerCase().contains(q)) ||
                             (p.getBrand() != null && p.getBrand().toLowerCase().contains(q)))
                .collect(Collectors.toList());
    }
}
