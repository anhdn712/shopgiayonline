package com.shopgiayonline.model.dto;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortProductInfoDto {
    private String id;

    private String name;

    private long price;

    List<Integer> availableSizes;

    public ShortProductInfoDto(String id, String name) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ShortProductInfoDto(String id, String name, long price, Object availableSizes) {
        this.id = id;
        this.name = name;
        this.price = price;
        if (availableSizes != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.availableSizes = mapper.readValue((String) availableSizes, new TypeReference<List<Integer>>() {
                });
            } catch (IOException e) {
                this.availableSizes = null;
            }
        }
    }
}
