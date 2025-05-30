package com.shopgiayonline.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginReq {
        @NotNull(message = "Email trống")
        @NotEmpty(message = "Email trống")
        @Email(message = "Email không đúng định dạng")
        @ApiModelProperty(notes = "Email trống", required = true)
        private String email;

        @NotNull(message = "Mật khẩu trống")
        @NotEmpty(message = "Mật khẩu trống")
        @Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự")
        @ApiModelProperty(notes = "Mật khẩu trống", required = true)
        private String password;
}
