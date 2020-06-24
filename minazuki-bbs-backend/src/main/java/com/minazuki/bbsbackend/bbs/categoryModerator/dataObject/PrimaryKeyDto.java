package com.minazuki.bbsbackend.bbs.categoryModerator.dataObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel
public class PrimaryKeyDto {
    @ApiModelProperty(value = "板块管理者id")
    @NotNull
    private Integer moderatorId;

    @ApiModelProperty(value = "被管理的板块的id")
    @NotNull
    private Integer categoryId;
}
