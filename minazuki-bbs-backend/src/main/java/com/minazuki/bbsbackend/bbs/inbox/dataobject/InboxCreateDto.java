package com.minazuki.bbsbackend.bbs.inbox.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@ApiModel
@NoArgsConstructor
public class InboxCreateDto {

    @ApiModelProperty(value = "发信人")
    private Integer senderId;

    @ApiModelProperty(value = "收信人")
    @NotNull
    private Integer recipientId;

    @ApiModelProperty(value = "私信内容")
    @NotNull
    private String content;
}
