/*
 Navicat Premium Data Transfer

 Source Server         : local_conn
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : njy

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/07/2021 10:21:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for njy_article
-- ----------------------------
DROP TABLE IF EXISTS `njy_article`;
CREATE TABLE `njy_article` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int DEFAULT '0' COMMENT '是否删除： 0 未删除 1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of njy_article
-- ----------------------------
BEGIN;
INSERT INTO `njy_article` VALUES (2001, 1001, 'SpringCloud微服务', 'SpringBoot、SpringCloud、SpringCloudAlibaba全家桶微服务开发', '2021-07-26 17:36:51', '2021-07-26 17:36:53', 0);
COMMIT;

-- ----------------------------
-- Table structure for njy_user
-- ----------------------------
DROP TABLE IF EXISTS `njy_user`;
CREATE TABLE `njy_user` (
  `id` bigint NOT NULL COMMENT '主键',
  `account` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` int DEFAULT '0' COMMENT '性别: 1 男 2 女 0 不确定',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int DEFAULT '1' COMMENT '状态：0 禁用 1 启用',
  `is_deleted` int DEFAULT '0' COMMENT '是否已删除： 0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Records of njy_user
-- ----------------------------
BEGIN;
INSERT INTO `njy_user` VALUES (1001, 'mqxu', '10470c3b4b1fed12c3baac014be15fac67c6e815', '陶然然', '许莫淇', 'http://qwspsqacu.hd-bkt.clouddn.com/upload/20210726/83cca8ff12b5f70ac6435fa528a7fb91.jpg', '16422802@qq.com', '13951905171', '1977-10-24', 2, '2021-07-26 13:52:55', '2021-07-26 13:53:12', 1, 0);
INSERT INTO `njy_user` VALUES (1419627401253183490, 'test_user', '123', 'test', 'test', '1.jpg', 'test@qq.com', '13899990000', '1990-10-24', 0, NULL, NULL, 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
