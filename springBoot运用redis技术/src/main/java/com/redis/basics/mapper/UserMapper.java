package com.redis.basics.mapper;

import com.redis.assist.domain.Page;
import com.redis.basics.entity.search.UserSearch;
import com.redis.basics.entity.vo.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/9 14:20
 */
@Mapper
public interface UserMapper {

    /**
     * 插入
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 查询
     * @param userSearch
     * @return
     */
    List<User> selectUser(UserSearch userSearch);

    List<User> getUser(UserSearch userSearch);

}
