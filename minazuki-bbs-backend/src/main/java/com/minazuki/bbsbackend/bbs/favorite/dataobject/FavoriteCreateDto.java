package com.minazuki.bbsbackend.bbs.favorite.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@ApiModel
public class FavoriteCreateDto {

    @ApiModelProperty(value = "收藏主题id")
    @NotNull
    private Integer themeId;

    @ApiModelProperty(value = "收藏者")
    @NotNull
    private Integer OwnerId;
}
