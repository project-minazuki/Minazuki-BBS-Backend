package com.minazuki.bbsbackend.bbs.notice.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ApiModel(value = "Notice更新的数据结构")
public class NoticeUpdateDto {

    @ApiModelProperty(value = "Notice的Id")
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "Notice的标题")
    private String title;

    @ApiModelProperty(value = "Notice的内容")
    private String content;

    @ApiModelProperty(value = "Notice的更新时间")
    private LocalDateTime updatedAt;
}
