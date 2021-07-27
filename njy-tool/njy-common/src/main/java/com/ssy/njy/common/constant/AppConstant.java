package com.ssy.njy.common.constant;

/**
 * 系统常量
 * @author: mqxu
 * @date: 2021-07-26
 **/
public interface AppConstant {
    /**
     * 应用版本
     */
    String APPLICATION_VERSION = "1.0.0";
    /**
     * 基础包
     */
    String BASE_PACKAGES = "com.ssy";
    /**
     * 应用名前缀
     */
    String APPLICATION_NAME_PREFIX = "njy-";
    /**
     * 网关模块名称
     */
    String APPLICATION_GATEWAY_NAME = APPLICATION_NAME_PREFIX + "gateway";
    /**
     * 认证授权模块名称
     */
    String APPLICATION_AUTH_NAME = APPLICATION_NAME_PREFIX + "auth";
    /**
     * 用户模块名称
     */
    String APPLICATION_USER_NAME = APPLICATION_NAME_PREFIX + "user";
    /**
     * 文章模块名称
     */
    String APPLICATION_ARTICLE_NAME = APPLICATION_NAME_PREFIX + "article";

    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PROD_CODE = "prod";
}
