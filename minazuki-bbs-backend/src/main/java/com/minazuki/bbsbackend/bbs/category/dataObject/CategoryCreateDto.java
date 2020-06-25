package com.minazuki.bbsbackend.bbs.category.dataObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "创建版块输入的数据结构")
public class CategoryCreateDto {

    @ApiModelProperty(value = "版块名称")
    @NotNull
    private String name;

    @ApiModelProperty(value = "版块描述")
    @NotNull
    private String description;
}
