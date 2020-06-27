package com.minazuki.bbsbackend.bbs.inbox.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@ApiModel(value = "私信查询入参")
@Data
@NoArgsConstructor
public class InboxIndexDto {
    @ApiModelProperty(value = "当前用户id")
    private Integer thisUserId;

    @ApiModelProperty(value = "目标用户id")
    @NotNull
    private Integer targetUserId;
}
