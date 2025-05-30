package com.shopgiayonline.model.request;

import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatePromotionReq {
    @NotNull(message = "Mã code rỗng")
    @NotEmpty(message = "Mã code rỗng")
    @Pattern(regexp = "^[0-9A-Z-]+$", message = "Mã code không đúng định dạng")
    private String code;

    @NotNull(message = "Tên rỗng")
    @NotEmpty(message = "Tên rỗng")
    @Size(min = 1, max = 300, message = "Độ dài tên từ 1 - 300 kí tự")
    private String name;

    @Min(1)
    @Max(2)
    @JsonProperty("discount_type")
    private int discountType;

    @JsonProperty("discount_value")
    private long discountValue;

    @JsonProperty("max_value")
    private long maxValue;

    @JsonProperty("is_public")
    private boolean isPublic;

    private boolean active;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonProperty("expired_date")
    private Timestamp expiredDate;
}
