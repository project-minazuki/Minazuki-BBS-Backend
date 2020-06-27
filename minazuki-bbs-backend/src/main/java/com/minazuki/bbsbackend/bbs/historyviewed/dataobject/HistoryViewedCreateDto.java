package com.minazuki.bbsbackend.bbs.historyviewed.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel("创建历史记录入参数据模型")
public class HistoryViewedCreateDto {

    @ApiModelProperty(value = "用户ID")
    private Integer ownerId;

    @ApiModelProperty(value = "查看主题ID")
    @NotNull
    private Integer viewedThemeId;

}
