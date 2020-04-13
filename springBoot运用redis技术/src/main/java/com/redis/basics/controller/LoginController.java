package com.redis.basics.controller;

import com.redis.assist.enumerate.CacheNameSpace;
import com.redis.assist.note.QueryCache;
import com.redis.assist.note.QueryCacheKey;
import com.redis.basics.entity.search.UserSearch;
import com.redis.basics.entity.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author 王阳
 * @date 2020/4/10 14:04
 */
@Api(value = "UserController",description = "登录")
@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @QueryCache(nameSpace = CacheNameSpace.SSO_USER)
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void selectUserByRedis(String name,String password){
       if(("123").equals(name)&&("123456").equals(password)){
           System.out.println("登录成功");
       }
    }

    @ApiOperation(value = "A使用redis查询查询用户")
    @RequestMapping(value = "/getUrl",method = RequestMethod.POST)
    @ResponseBody
    public void getUrl() throws Exception{
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        props.load(is);
        String url = props.getProperty("spring.datasource.url");
        int i1=url.indexOf('/');
        int i2=url.indexOf('/',i1+1);
        int i3=url.indexOf('/',i2+1);
        url=url.substring(i3+1,url.lastIndexOf("?"));
    }
}
