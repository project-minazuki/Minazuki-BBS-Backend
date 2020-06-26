package com.minazuki.bbsbackend.bbs.theme.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ApiModel(value = "Theme更新的数据结构")
public class ThemeUpdateDto {
    @ApiModelProperty(value = "主题帖的Id")
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "是否置顶")
    private Boolean isTop;

    @ApiModelProperty(value = "是否是精品帖")
    private Boolean isHighQuality;

    @ApiModelProperty(value = "Theme的状态")
    private Boolean status;

    @ApiModelProperty(value = "主题帖标题")
    private String title;

    @ApiModelProperty(value = "主题帖访问数")
    private Integer visitsCount;

    @ApiModelProperty(value = "主题帖回复数")
    private Integer replyCount;

    @ApiModelProperty(value = "最后回复时间")
    private LocalDateTime latestReplyAt;

    //Service层自动更新时间，传参时不用填
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedAt;
}
