package com.redis.basics.entity.vo;

import com.redis.assist.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/4/9 13:48
 */
@ApiModel(value = "User",description = "用户表",parent = BaseDomain.class)
public class User extends BaseDomain {
    
    @ApiModelProperty(value = "用户姓名")
    private String name ;
    @ApiModelProperty(value = "用户性别")
    private String sex ;
    @ApiModelProperty(value = "家庭住址")
    private String address ;
    @ApiModelProperty(value = "电话号码")
    private String telephone ;
    @ApiModelProperty(value = "手机号码")
    private String cellphone ;
    @ApiModelProperty(value = "身份证号码")
    private  String identityCard ;
    @ApiModelProperty(value = "出生时间")
    private String birth ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
