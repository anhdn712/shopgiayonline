package com.shopgiayonline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductInfoDto {
    private String id;

    private String name;

    private String slug;

    private long price;

    private int totalSold;

    private String image;

    private long promotionPrice;

    public ProductInfoDto(String id, String name, String slug, long price, int totalSold, String image) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.price = price;
        this.totalSold = totalSold;
        this.image = image;
    }
}
