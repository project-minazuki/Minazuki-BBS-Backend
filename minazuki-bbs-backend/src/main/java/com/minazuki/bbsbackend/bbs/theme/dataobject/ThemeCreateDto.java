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

    @ApiModelProperty
    @NotNull
    private String title;

    @ApiModelProperty
    @NotNull
    private Integer creatorId;

    @ApiModelProperty
    @NotNull
    private Integer categoryId;

}
