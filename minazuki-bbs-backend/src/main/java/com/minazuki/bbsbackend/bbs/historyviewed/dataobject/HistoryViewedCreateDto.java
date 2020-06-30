package com.minazuki.bbsbackend.bbs.historyviewed.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "创建历史记录入参")
@NoArgsConstructor
public class HistoryViewedCreateDto {

    @ApiModelProperty(value = "历史记录所属用户id")
    private Integer ownerId;

    @ApiModelProperty(value = "所浏览的主题帖")
    private Integer viewedThemeId;

}
