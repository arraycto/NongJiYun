package com.ssy.njy.service.user.service;

import com.ssy.njy.api.user.entity.User;
import com.ssy.njy.api.user.vo.UserVO;

/**
 * UserService
 *
 * @author: mqxu
 * @since: 2021-07-26
 **/
public interface UserService {
    /**
     * 根据id查找用户
     *
     * @param userId 用户id
     * @return User
     */
    User getUser(Long userId);

    /**
     * 根据id查找UserVO
     *
     * @param userId 用户id
     * @return UserVO
     */
    UserVO getUserVO(Long userId);

    /**
     * 新增用户
     *
     * @param user user对象
     * @return Boolean
     */
    Boolean saveUser(User user);
}
