package com.minazuki.bbsbackend.bbs.category.dataobject;

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
    private String name;

    @ApiModelProperty(value = "版块状态")
    private Boolean status;

    @ApiModelProperty(value = "版块描述")
    private String description;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "版块访问数")
    private Integer visitsCount;

    @ApiModelProperty(value = "版块封面路径")
    private String coverUrl;

    public boolean isAllNull()
    {
        return name == null && status == null && description == null &&
                updatedAt == null && visitsCount == null && coverUrl == null;
    }
}
