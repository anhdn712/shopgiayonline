package com.shopgiayonline.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostReq {
    @NotNull(message = "Tiêu đề rỗng")
    @NotEmpty(message = "Tiêu đề rỗng")
    @Size(min = 1, max = 300, message = "Độ dài tiêu đề từ 1 - 300 ký tự")
    private String title;

    @NotNull(message = "Nội dung rỗng")
    @NotEmpty(message = "Nội dung rỗng")
    private String content;

    private String description;

    private int status;

    private String image;
}
