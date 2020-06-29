package com.minazuki.bbsbackend.bbs.tag.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "建立theme和tag联系的入参")
public class ThemeTagLinkDto {

    @ApiModelProperty(value = "主题帖id")
    @NotNull
    private Integer themeId;

    @ApiModelProperty(value = "tag id")
    @NotNull
    private Integer tagId;
}
