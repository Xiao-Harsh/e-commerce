package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private Long id;
    private String title;
    private String description;
    private String brand;

    @Builder.Default
    private String gender = "Unisex";

    @Builder.Default
    private String color = "Multicolor";

    private Double price;
    private Double discountPrice;
    private Integer stock;
    private Category category;

    @Builder.Default
    private List<ProductImage> productImages = new ArrayList<>();

    @Builder.Default
    private List<ProductSize> productSizes = new ArrayList<>();

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    // ==========================================
    // Backward Compatibility Getters/Setters for Frontend
    // ==========================================

    @JsonProperty("name")
    public String getName() {
        return title;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        if (productImages != null && !productImages.isEmpty()) {
            return productImages.get(0).getImageUrl();
        }
        return null;
    }

    @JsonProperty("sizes")
    public String getSizes() {
        if (productSizes != null && !productSizes.isEmpty()) {
            return productSizes.stream()
                    .map(ProductSize::getSize)
                    .collect(Collectors.joining(","));
        }
        return "";
    }

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return category != null ? category.getName() : null;
    }

    @JsonProperty("category")
    public String getCategoryComp() {
        return category != null ? category.getName() : null;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.title = name;
    }

    @JsonProperty("imageUrl")
    public void setImageUrlComp(String url) {
        this.productImages = new ArrayList<>();
        if (url != null && !url.trim().isEmpty()) {
            ProductImage pi = ProductImage.builder()
                    .imageUrl(url)
                    .product(this)
                    .build();
            this.productImages.add(pi);
        }
    }

    @JsonProperty("sizes")
    public void setSizesComp(String sizesStr) {
        this.productSizes = new ArrayList<>();
        if (sizesStr != null && !sizesStr.trim().isEmpty()) {
            String[] sizeArray = sizesStr.split(",");
            for (String size : sizeArray) {
                String cleanSize = size.trim();
                if (!cleanSize.isEmpty()) {
                    ProductSize ps = ProductSize.builder()
                            .size(cleanSize)
                            .quantity(12)
                            .product(this)
                            .build();
                    this.productSizes.add(ps);
                }
            }
        }
    }

    @JsonProperty("category")
    public void setCategoryComp(Object categoryObj) {
        if (categoryObj instanceof String) {
            this.category = Category.builder().name((String) categoryObj).build();
        } else if (categoryObj instanceof java.util.Map) {
            java.util.Map<?, ?> map = (java.util.Map<?, ?>) categoryObj;
            String name = (String) map.get("name");
            Long id = map.get("id") != null ? Long.valueOf(map.get("id").toString()) : null;
            this.category = Category.builder().id(id).name(name).build();
        }
    }
}
