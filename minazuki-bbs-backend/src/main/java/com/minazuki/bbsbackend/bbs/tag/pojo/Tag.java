package com.minazuki.bbsbackend.bbs.tag.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("Tag")
@ToString
@Builder
public class Tag {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
