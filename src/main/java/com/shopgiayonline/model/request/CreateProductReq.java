package com.shopgiayonline.model.request;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductReq {
        @NotNull(message = "Tên sản phẩm trống")
        @NotEmpty(message = "Tên sản phẩm trống")
        @Size(min = 1, max = 300, message = "Độ dài tên sản phẩm từ 1 - 300 ký tự")
        @ApiModelProperty(example = "Adidas KH422", notes = "Tên sản phẩm trống", required = true)
        private String name;

        @NotNull(message = "Mô tả trống")
        @NotEmpty(message = "Mô tả trống")
        @ApiModelProperty(example = "Lorem", notes = "Mô tả trống", required = true)
        private String description;

        @NotNull(message = "Nhãn hiệu trống")
        @ApiModelProperty(example = "1", notes = "Nhãn hiệu trống", required = true)
        @JsonProperty("brand_id")
        private Integer brandId;

        @NotNull(message = "Category trống")
        @ApiModelProperty(example = "[1]", notes = "Category trống", required = true)
        @JsonProperty("category_ids")
        private ArrayList<Integer> categoryIds;

        @JsonProperty("is_available")
        private boolean isAvailable;

        @Min(1000)
        @Max(1000000000)
        @ApiModelProperty(example = "4000000", notes = "Giá tiền không hợp lệ", required = true)
        private Integer price;

        @NotNull(message = "Danh sách ảnh trống")
        @ApiModelProperty(example = "[img1.jpg, img2.jpg]", notes = "Danh sách ảnh trống", required = true)
        @JsonProperty("product_images")
        private ArrayList<String> productImages;
}
