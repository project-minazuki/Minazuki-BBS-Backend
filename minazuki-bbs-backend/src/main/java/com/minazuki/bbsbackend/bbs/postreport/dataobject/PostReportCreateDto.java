package com.minazuki.bbsbackend.bbs.postreport.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@ApiModel(value = "举报回帖")
@NoArgsConstructor
public class PostReportCreateDto {

    @ApiModelProperty(value = "举报对象")
    @NotNull
    private Integer postId;

    @ApiModelProperty(value = "举报原因")
    @NotNull
    private String reason;

    @ApiModelProperty(value = "举报人")
    private Integer reporterId;
}
