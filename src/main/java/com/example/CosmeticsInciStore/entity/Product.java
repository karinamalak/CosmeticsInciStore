package com.example.CosmeticsInciStore.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "amount", nullable = false)
    private int amount;

    @NotNull
    @Column(name = "price", nullable = false)
    private int price;

    @NotBlank
    @Column(name = "category", nullable = false)
    private String category;

    @NotBlank
    @Column (name = "measure", nullable = false)
    private String measure;

    @NotBlank
    @Column (name = "description", nullable = false)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount &&
                price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category) &&
                Objects.equals(measure, product.measure) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, price, category, measure, description);
    }
}
