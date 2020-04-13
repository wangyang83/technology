package com.redis.assist.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王阳
 * @date 2020/4/9 14:05
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date  createDate ;
    @ApiModelProperty(value = "创建人",hidden = true)
    private String createUser ;
    @ApiModelProperty(value = "更新时间",hidden = true)
    private Date updateDate ;
    @ApiModelProperty(value = "更新人",hidden = true)
    private String updateUser ;
    @ApiModelProperty(value = "删除标记",hidden = true)
    private Boolean deleteFlag ;
    @ApiModelProperty(value = "删除时间",hidden = true)
    private Date deleteDate ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
