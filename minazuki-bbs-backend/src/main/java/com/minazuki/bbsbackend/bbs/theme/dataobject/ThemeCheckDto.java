package com.minazuki.bbsbackend.bbs.theme.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "用于创建主题贴时检查同一个版块中是否有标题相同的主题帖")
public class ThemeCheckDto {
    @ApiModelProperty(value = "主题帖Id")
    @NotNull
    private String title;

    @ApiModelProperty(value = "主题帖所在版块Id")
    @NotNull
    private Integer categoryId;
}