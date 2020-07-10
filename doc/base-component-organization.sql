/*
 Navicat MySQL Data Transfer

 Source Server         : 23环境
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 172.31.118.23:3306
 Source Schema         : org_test1

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 09/07/2020 15:41:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

create database `base-component-organization` character set utf8mb4 collate utf8mb4_general_ci;

use `base-component-organization`;
-- ----------------------------
-- Table structure for t_tenant_info1
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant_info1`;
CREATE TABLE `t_tenant_info1`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码md5值',
  `password_salt` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值时间戳',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定邮箱',
  `is_enable` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用 1是，0否',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`tenant_id`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `idx_email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tenant_info0
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant_info0`;
CREATE TABLE `t_tenant_info0`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码md5值',
  `password_salt` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值时间戳',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定邮箱',
  `is_enable` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用 1是，0否',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`tenant_id`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `idx_email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization_info1
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_info1`;
CREATE TABLE `t_organization_info1`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `org_id` bigint(20) UNSIGNED NOT NULL COMMENT '组织ID',
  `org_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序号',
  `member_count` int(11) UNSIGNED NOT NULL COMMENT '组织人数',
  `parent_org_id` bigint(20) UNSIGNED NOT NULL COMMENT '父组织id',
  `id_path` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id路径',
  `name_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称路径',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`org_id`) USING BTREE,
  INDEX `idx_id_path`(`id_path`) USING BTREE,
  INDEX `idx_parent_org_id`(`parent_org_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization_info0
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_info0`;
CREATE TABLE `t_organization_info0`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `org_id` bigint(20) UNSIGNED NOT NULL COMMENT '组织ID',
  `org_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序号',
  `member_count` int(11) UNSIGNED NOT NULL COMMENT '组织人数',
  `parent_org_id` bigint(20) UNSIGNED NOT NULL COMMENT '父组织id',
  `id_path` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id路径',
  `name_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称路径',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`org_id`) USING BTREE,
  INDEX `idx_id_path`(`id_path`) USING BTREE,
  INDEX `idx_parent_org_id`(`parent_org_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization_info
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_info`;
CREATE TABLE `t_organization_info`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `org_id` bigint(20) UNSIGNED NOT NULL COMMENT '组织ID',
  `org_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序号',
  `member_count` int(11) UNSIGNED NOT NULL COMMENT '组织人数',
  `parent_org_id` bigint(20) UNSIGNED NOT NULL COMMENT '父组织id',
  `id_path` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id路径',
  `name_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称路径',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`org_id`) USING BTREE,
  INDEX `idx_id_path`(`id_path`) USING BTREE,
  INDEX `idx_parent_org_id`(`parent_org_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant_info`;
CREATE TABLE `t_tenant_info`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码md5值',
  `password_salt` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值时间戳',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定邮箱',
  `is_enable` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用 1是，0否',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`tenant_id`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `idx_email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization_member
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_member`;
CREATE TABLE `t_organization_member`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键',
  `org_id` bigint(20) UNSIGNED NOT NULL COMMENT '组织id',
  `member_id` bigint(20) UNSIGNED NOT NULL COMMENT '成员id',
  `org_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织名称',
  `member_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成员名称',
  `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织成员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_member_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_info`;
CREATE TABLE `t_member_info`  (
  `tenant_id` bigint(20) UNSIGNED NOT NULL COMMENT '租户id',
  `member_id` bigint(20) UNSIGNED NOT NULL COMMENT '成员id',
  `member_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成员名称',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码md5值',
  `password_salt` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值时间戳',
  `sex` tinyint(2) UNSIGNED NOT NULL COMMENT '性别：1男 2女 0未知',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电子邮件',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
