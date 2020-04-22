package com.redis.basics.controller;

import com.redis.assist.domain.ResultDo;
import com.redis.basics.entity.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author 王阳
 * @date 2020/4/15 10:07
 */
@Api(value = "ReflectController",description = "反射")
@RequestMapping(value = "/Reflect")
@Controller
public class ReflectController {

    @ApiOperation(value = "反射各种方法")
    @RequestMapping(value = "/getReflect", method = RequestMethod.POST)
    @ResponseBody
    public void getReflect(Long id) {

        User user = new User();
        Class personClazz01 = user.getClass();

        System.out.println(personClazz01.getName());
        System.out.println(personClazz01.getPackage());
        System.out.println(personClazz01.getInterfaces());

        Class u = User.class;
        System.out.println(u.getPackage());

        try {
            Class i = Class.forName("com.redis.basics.entity.vo.User");
            System.out.println(i.getPackage());

            //获取公有字段
            Field[] fields = i.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            //获取私有字段
            fields = i.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }
            Field f = i.getDeclaredField("name");
            Object obj = i.getConstructor().newInstance();
            User us = (User) obj;
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj, "w");
            System.out.println(us);
            Constructor[] conArray = i.getConstructors();
            for (Constructor c:conArray) {
                System.out.println("构造方法:"+c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

