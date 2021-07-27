package com.ssy.njy.service.article.feign;

import com.ssy.njy.api.user.vo.UserVO;
import com.ssy.njy.common.constant.AppConstant;
import com.ssy.njy.common.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * UserFeign接口
 *
 * @author: mqxu
 * @date: 2021-07-26
 */
@FeignClient(value = AppConstant.APPLICATION_USER_NAME)
public interface UserClient {

    String API_PREFIX = "/user";

    /**
     * 根据id获取用户VO
     *
     * @param userId 用户id
     * @return R<UserVO>
     */
    @GetMapping(API_PREFIX + "/info/{userId}")
    R<UserVO> getUserInfo(@PathVariable Long userId);

}
