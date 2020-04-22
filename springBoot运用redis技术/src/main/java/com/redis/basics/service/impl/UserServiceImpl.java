package com.redis.basics.service.impl;

import com.redis.assist.domain.Page;
import com.redis.assist.domain.SimplePage;
import com.redis.basics.entity.search.UserSearch;
import com.redis.basics.entity.vo.User;
import com.redis.basics.mapper.UserMapper;
import com.redis.basics.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/9 14:19
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        try{
            userMapper.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    /**
     * B
     */

    public Page selectUser(UserSearch userSearch) {
        Page page = null;
        try{
            List<User> users = userMapper.getUser(userSearch);
            page = new Page(userSearch);
            page.setData(users);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }
}
