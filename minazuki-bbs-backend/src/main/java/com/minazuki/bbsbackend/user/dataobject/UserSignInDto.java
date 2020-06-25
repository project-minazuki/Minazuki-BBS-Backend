package com.minazuki.bbsbackend.user.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel("登录信息入参数据模型")
public class UserSignInDto {

    @ApiModelProperty(value = "用户名/邮箱/电话号码")
    @NotNull
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull
    private String password;

}
