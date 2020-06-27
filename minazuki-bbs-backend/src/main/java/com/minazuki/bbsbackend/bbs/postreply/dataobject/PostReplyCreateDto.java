package com.minazuki.bbsbackend.bbs.postreply.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "普通帖子的回复（楼中楼）入参数据模型")
public class PostReplyCreateDto {

    @ApiModelProperty(value = "回复的帖子")
    @NotNull
    private Integer targetPostId;

    @ApiModelProperty(value = "回复内容")
    @NotNull
    private String content;

    @ApiModelProperty(value = "回复创建者")
    private Integer postReplyCreatorId;
}
