package com.minazuki.bbsbackend.bbs.notification.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel("新建通知入参")
public class NotificationCreateDto {

    @ApiModelProperty(value = "通知接收者id")
    @NotNull
    private Integer recipientId;

    @ApiModelProperty(value = "通知内容")
    @NotNull
    private String content;
}
