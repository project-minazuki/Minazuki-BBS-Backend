package com.minazuki.bbsbackend.bbs.post.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@ApiModel(value = "更新回帖入参")
@NoArgsConstructor
public class PostUpdateDto {

    @ApiModelProperty(value = "更新回帖id")
    @NotNull
    private Integer postId;

    @ApiModelProperty(value = "更新内容")
    @NotNull
    private String content;
}
