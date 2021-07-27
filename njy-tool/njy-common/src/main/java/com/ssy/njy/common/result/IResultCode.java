package com.ssy.njy.common.result;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @author: mqxu
 * @since: 2021-07-26
 **/
public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
