package com.redis.basics.service;

import com.redis.assist.domain.Page;
import com.redis.basics.entity.search.UserSearch;
import com.redis.basics.entity.vo.User;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/9 14:18
 */
public interface UserService {
    /**
     * 创建用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 查询用户
     * @param userSearch
     * @return
     */
    public Page selectUser(UserSearch userSearch);
}

