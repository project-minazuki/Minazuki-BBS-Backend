package com.minazuki.bbsbackend.bbs.notice.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@ApiModel(value = "创建公告入参")
@Data
@NoArgsConstructor
public class NoticeCreateDto {

    @ApiModelProperty(value = "公告标题")
    @NotNull
    private String title;

    @ApiModelProperty(value = "公告内容")
    @NotNull
    private String content;

    // 注意，这个id直接从前端接收数据时不会被赋值，需要之后从登陆状态拦截器去获取当前用户id，服务层会做检测
    @ApiModelProperty(value = "创建者ID")
    private Integer creatorId;

    @ApiModelProperty(value = "所属版块")
    @NotNull
    private Integer categoryId;
}
