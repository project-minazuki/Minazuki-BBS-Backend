package com.minazuki.bbsbackend.bbs.categorymoderator.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "创建版主和板块关系时的入参和作主键用")
public class ModeratorPrimaryKeyDto {
    @ApiModelProperty(value = "板块管理者id")
    @NotNull
    private Integer moderatorId;

    @ApiModelProperty(value = "被管理的板块的id")
    @NotNull
    private Integer categoryId;
}
