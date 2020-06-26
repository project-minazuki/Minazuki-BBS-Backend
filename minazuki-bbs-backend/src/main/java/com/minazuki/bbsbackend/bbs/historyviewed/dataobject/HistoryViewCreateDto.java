package com.minazuki.bbsbackend.bbs.historyviewed.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class HistoryViewCreateDto {

    @ApiModelProperty(value = "历史记录所属用户id")
    private Integer ownerId;

    @ApiModelProperty(value = "所浏览的主题帖")
    private Integer viewedThemeId;

}
