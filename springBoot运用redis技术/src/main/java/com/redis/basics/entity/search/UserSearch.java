package com.redis.basics.entity.search;

import com.redis.assist.domain.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/4/9 15:34
 */
@ApiModel(value = "UserSearch",description = "用户表-查询")
public class UserSearch extends Page {

    @ApiModelProperty(value = "姓名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                "name='" + name + '\'' +
                '}';
    }
}

