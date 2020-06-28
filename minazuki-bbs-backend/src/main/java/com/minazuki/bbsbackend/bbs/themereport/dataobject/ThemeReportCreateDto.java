package com.minazuki.bbsbackend.bbs.themereport.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ApiModel(value = "创建ThemeReport所用数据结构")
public class ThemeReportCreateDto {

    @ApiModelProperty(value = "主题帖的Id")
    @NotNull
    private Integer themeId;

    @ApiModelProperty(value = "举报者的Id")
    private Integer reporterId;

    @ApiModelProperty(value = "举报原因")
    @NotNull
    private String reason;
}
