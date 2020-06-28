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

    @ApiModelProperty(value = "主题帖标题")
    private String title;

    public boolean isNoTitle() {
        if(this.title == null) return true;
        else return false;
    }
}
