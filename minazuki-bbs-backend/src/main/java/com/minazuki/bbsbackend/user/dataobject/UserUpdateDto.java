package com.minazuki.bbsbackend.user.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "更新用户资料入参数据模型")
public class UserUpdateDto {

    @ApiModelProperty(value = "用户id")
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "更新后昵称")
    private String nickname;

    @ApiModelProperty(value = "更新后签名")
    private String signature;

    @ApiModelProperty(value = "更新后头像url")
    private String avatarUrl;

    @ApiModelProperty(value = "更新后隐私设置")
    private Boolean privacyShow;

    public boolean isAllNull() {
        return nickname == null && signature == null && avatarUrl == null && privacyShow == null;
    }
}
