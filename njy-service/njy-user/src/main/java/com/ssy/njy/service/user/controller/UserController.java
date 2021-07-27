package com.ssy.njy.service.user.controller;

import com.ssy.njy.api.user.entity.User;
import com.ssy.njy.api.user.vo.UserVO;
import com.ssy.njy.common.result.R;
import com.ssy.njy.service.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author: mqxu
 * @date: 2021-07-26
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("test")
    public R<String> test() {
        return R.data("test user");
    }

    @ApiOperation(value = "根据id查询用户详情", notes = "传入用户id")
    @GetMapping("/detail/{userId}")
    public R<User> getUserDetail(@PathVariable Long userId) {
        User detail = userService.getUser(userId);
        return R.data(detail);
    }

    @ApiOperation(value = "根据id查询用户VO", notes = "传入用户id")
    @GetMapping("/info/{userId}")
    public R<UserVO> getUserInfo(@PathVariable Long userId) {
        UserVO userVO = userService.getUserVO(userId);
        return R.data(userVO);
    }
}
