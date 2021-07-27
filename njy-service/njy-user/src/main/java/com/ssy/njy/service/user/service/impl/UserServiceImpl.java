package com.ssy.njy.service.user.service.impl;

import com.ssy.njy.api.user.entity.User;
import com.ssy.njy.api.user.vo.UserVO;
import com.ssy.njy.service.user.mapper.UserMapper;
import com.ssy.njy.service.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: mqxu
 * @date: 2021-07-26
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public UserVO getUserVO(Long userId) {
        User detail = userMapper.selectById(userId);
        return UserVO.builder()
                .id(userId)
                .account(detail.getAccount())
                .name(detail.getName())
                .avatar(detail.getAvatar())
                .phone(detail.getPhone())
                .gender(detail.getGender())
                .build();
    }

    @Override
    public Boolean saveUser(User user) {
        return userMapper.insert(user) != 0;
    }
}
