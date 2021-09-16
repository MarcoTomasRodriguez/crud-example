package com.marcotomasrodriguez.crudexample.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateProductDto {
    @NotNull
    @NotBlank
    private String title;

    private String description;

    @NotNull
    @Min(value = 0)
    private Integer stock;

    @NotNull
    @Min(value = 0)
    private Double price;
}

