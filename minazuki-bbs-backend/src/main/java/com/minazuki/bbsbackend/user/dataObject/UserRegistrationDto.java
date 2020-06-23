package com.minazuki.bbsbackend.user.dataObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "用户注册表单入参数据模型")
public class UserRegistrationDto {

    @ApiModelProperty(value = "昵称")
    @NotNull
    private String nickname;

    @ApiModelProperty(value = "用户名")
    @NotNull
    private String username;

    @ApiModelProperty(value ="密码")
    @NotNull
    private String password;

    @ApiModelProperty(value = "电话号码")
    @NotNull
    private String phoneNumber;

    @ApiModelProperty(value = "电子邮箱")
    @NotNull
    private String email;

}
