package com.minazuki.bbsbackend.bbs.theme.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ApiModel(value = "用于Theme创建的数据结构")
public class ThemeCreateDto {

    @ApiModelProperty(value = "创建主题帖标题")
    @NotNull
    private String title;

    @ApiModelProperty(value = "创建者的Id")
    @NotNull
    private Integer creatorId;

    @ApiModelProperty(value = "主题帖所在版块的Id")
    @NotNull
    private Integer categoryId;

}
