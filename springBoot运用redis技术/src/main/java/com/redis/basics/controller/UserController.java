package com.redis.basics.controller;

import com.redis.assist.domain.Page;
import com.redis.assist.domain.ResultDo;
import com.redis.assist.enumerate.CacheNameSpace;
import com.redis.assist.note.QueryCache;
import com.redis.assist.note.QueryCacheKey;
import com.redis.basics.entity.search.UserSearch;
import com.redis.basics.entity.vo.User;
import com.redis.basics.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/9 13:47
 */
@Api(value = "UserController",description = "用户")
@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Resource
    private UserService userService;


    @QueryCache(nameSpace = CacheNameSpace.SSO_USER)
    @ApiOperation(value = "A使用redis查询查询用户")
    @RequestMapping(value = "/selectUserByRedis",method = RequestMethod.POST)
    @ResponseBody
    public List<User> selectUserByRedis(@QueryCacheKey UserSearch userSearch){
        List<User> users= null;
        try{
//            users = userService.selectUser(userSearch);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/selectUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultDo<Page> selectUser(UserSearch userSearch){
        ResultDo<Page> result = new ResultDo<>();
        Page page= null;
        try{
            page = userService.selectUser(userSearch);
            result.setSuccessWithResult(page);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    @ResponseBody
    public void insertUser(User user){
        try{
            userService.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
