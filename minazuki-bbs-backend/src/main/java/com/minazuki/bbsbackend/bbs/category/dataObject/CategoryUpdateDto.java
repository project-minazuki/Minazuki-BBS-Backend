package com.minazuki.bbsbackend.bbs.category.dataObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ApiModel(value = "更新版块的数据结构")
public class CategoryUpdateDto {

    @ApiModelProperty(value = "版块id")
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "版块名称")
    @NotNull
    private String name;

    @ApiModelProperty(value = "版块状态")
    @NotNull
    private Boolean status;

    @ApiModelProperty(value = "版块描述")
    @NotNull
    private String description;

    @ApiModelProperty(value = "更新时间")
    @NotNull
    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "附件路径")
    private String coverUrl;
}
