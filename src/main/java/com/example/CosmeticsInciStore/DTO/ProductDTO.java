package com.example.CosmeticsInciStore.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
public class ProductDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Long amount;

    @NotNull
    private int price;

    @NotBlank
    private String category;

    @NotBlank
    private String measure;

    @NotBlank
    private String description;

}
