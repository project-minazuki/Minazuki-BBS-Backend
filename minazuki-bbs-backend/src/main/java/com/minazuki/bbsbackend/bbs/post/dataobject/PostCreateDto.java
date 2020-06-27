package com.minazuki.bbsbackend.bbs.post.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@ApiModel(value = "新建回帖入参数据模型")
@NoArgsConstructor
public class PostCreateDto {

    @ApiModelProperty(value = "回帖创建者id")
    private Integer creatorId;

    @ApiModelProperty(value = "楼数")
    private Integer number;

    @ApiModelProperty(value = "回帖内容")
    @NotNull
    private String content;

    @ApiModelProperty(value = "所属主题帖")
    @NotNull
    private Integer themeId;
}
