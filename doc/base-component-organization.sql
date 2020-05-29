/*
 Navicat MySQL Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : base-component-organization

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 29/05/2020 15:18:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `id_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id路径',
  `name_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称路径',
  `is_deleted` tinyint(2) UNSIGNED NOT NULL COMMENT '是否删除：1是 0否',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_organization_info
-- ----------------------------
INSERT INTO `t_organization_info` VALUES (429350896271360007, 429350896489463843, 'dev1', 0, 0, 0, '429350896489463843,', 'dev1', 0, '2020-03-30 18:47:11', '2020-03-30 18:47:11');
INSERT INTO `t_organization_info` VALUES (450340969678639127, 450341537344131124, 'dev1914', 0, 0, 0, '450341537344131124,', 'dev1914', 0, '2020-05-27 16:56:31', '2020-05-27 16:56:31');
INSERT INTO `t_organization_info` VALUES (450342396387922010, 450342396715077727, 'dev1398', 0, 0, 0, '450342396715077727,', 'dev1398', 0, '2020-05-27 16:59:54', '2020-05-27 16:59:54');
INSERT INTO `t_organization_info` VALUES (450700353969590306, 450700354258997263, 'dev1122', 0, 0, 0, '450700354258997263,', 'dev1122', 0, '2020-05-28 16:42:18', '2020-05-28 16:42:18');
INSERT INTO `t_organization_info` VALUES (450701008385871939, 450701008612364322, 'dev1143', 0, 0, 0, '450701008612364322,', 'dev1143', 0, '2020-05-28 16:44:54', '2020-05-28 16:44:54');
INSERT INTO `t_organization_info` VALUES (450703309427183625, 450703309599150148, 'dev1804', 0, 0, 0, '450703309599150148,', 'dev1804', 0, '2020-05-28 16:54:03', '2020-05-28 16:54:03');
INSERT INTO `t_organization_info` VALUES (450703830074527744, 450703875964407865, 'dev1618', 0, 0, 0, '450703875964407865,', 'dev1618', 0, '2020-05-28 16:56:18', '2020-05-28 16:56:18');
INSERT INTO `t_organization_info` VALUES (450704855124676620, 450704855334391837, 'dev1967', 0, 0, 0, '450704855334391837,', 'dev1967', 0, '2020-05-28 17:00:11', '2020-05-28 17:00:11');
INSERT INTO `t_organization_info` VALUES (450705076349046838, 450705076575539232, 'dev1118', 0, 0, 0, '450705076575539232,', 'dev1118', 0, '2020-05-28 17:01:04', '2020-05-28 17:01:04');
INSERT INTO `t_organization_info` VALUES (450705350228709446, 450705350480367695, 'dev1109', 0, 0, 0, '450705350480367695,', 'dev1109', 0, '2020-05-28 17:02:09', '2020-05-28 17:02:09');
INSERT INTO `t_organization_info` VALUES (450705645411242072, 450705645637734480, 'dev1538', 0, 0, 0, '450705645637734480,', 'dev1538', 0, '2020-05-28 17:03:20', '2020-05-28 17:03:20');
INSERT INTO `t_organization_info` VALUES (450706274296795146, 450706274598785029, 'dev1393', 0, 0, 0, '450706274598785029,', 'dev1393', 0, '2020-05-28 17:05:50', '2020-05-28 17:05:50');
INSERT INTO `t_organization_info` VALUES (450706692569567234, 450706692863168592, 'dev1189', 0, 0, 0, '450706692863168592,', 'dev1189', 0, '2020-05-28 17:07:29', '2020-05-28 17:07:29');
INSERT INTO `t_organization_info` VALUES (450706892621090910, 450706892746920026, 'dev1127', 0, 0, 0, '450706892746920026,', 'dev1127', 0, '2020-05-28 17:08:17', '2020-05-28 17:08:17');
INSERT INTO `t_organization_info` VALUES (450967791374176352, 450967791533559894, 'dev1663', 0, 0, 0, '450967791533559894,', 'dev1663', 0, '2020-05-29 10:25:00', '2020-05-29 10:25:00');
INSERT INTO `t_organization_info` VALUES (450970236938621025, 450970237131558942, 'dev1849', 0, 0, 0, '450970237131558942,', 'dev1849', 0, '2020-05-29 10:34:43', '2020-05-29 10:34:43');
INSERT INTO `t_organization_info` VALUES (450970608566538329, 450970608772059153, 'dev1749', 0, 0, 0, '450970608772059153,', 'dev1749', 0, '2020-05-29 10:36:12', '2020-05-29 10:36:12');
INSERT INTO `t_organization_info` VALUES (450974450951655436, 450974451169759318, 'dev1652', 0, 0, 0, '450974451169759318,', 'dev1652', 0, '2020-05-29 10:51:28', '2020-05-29 10:51:28');

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
  PRIMARY KEY (`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tenant_info
-- ----------------------------
INSERT INTO `t_tenant_info` VALUES (429283014078365766, 'admin', '123456', '1', '18823660299', 'admin', 0, '2020-03-30 06:17:26', '', '2020-03-30 06:17:26', '2020-03-30 06:17:26');
INSERT INTO `t_tenant_info` VALUES (429350896271360007, 'dev1', 'a', '1', '18823660291', 'dev1@qq.com', 1, '2020-03-30 18:47:11', '', '2020-03-30 18:47:11', '2020-03-30 18:47:11');
INSERT INTO `t_tenant_info` VALUES (450340969678639127, 'dev1914', '123', '1', '18823660914', 'dev914@qq.com', 1, '2020-05-27 16:54:14', '', '2020-05-27 16:54:14', '2020-05-27 16:54:14');
INSERT INTO `t_tenant_info` VALUES (450342396387922010, 'dev1398', '123', '1', '18823660398', 'dev398@qq.com', 0, '2020-05-27 16:59:54', '', '2020-05-27 16:59:54', '2020-05-27 16:59:54');
INSERT INTO `t_tenant_info` VALUES (450700353969590306, 'dev1122', '123', '1', '18823660122', 'dev122@qq.com', 0, '2020-05-28 16:42:18', '', '2020-05-28 16:42:18', '2020-05-28 16:42:18');
INSERT INTO `t_tenant_info` VALUES (450701008385871939, 'dev1143', '123', '1', '18823660143', 'dev143@qq.com', 0, '2020-05-28 16:44:54', '', '2020-05-28 16:44:54', '2020-05-28 16:44:54');
INSERT INTO `t_tenant_info` VALUES (450703309427183625, 'dev1804', '123', '1', '18823660804', 'dev804@qq.com', 0, '2020-05-28 16:54:03', '', '2020-05-28 16:54:03', '2020-05-28 16:54:03');
INSERT INTO `t_tenant_info` VALUES (450703830074527744, 'dev1618', '123', '1', '18823660618', 'dev618@qq.com', 0, '2020-05-28 16:56:07', '', '2020-05-28 16:56:07', '2020-05-28 16:56:07');
INSERT INTO `t_tenant_info` VALUES (450704855124676620, 'dev1967', '123', '1', '18823660967', 'dev967@qq.com', 0, '2020-05-28 17:00:11', '', '2020-05-28 17:00:11', '2020-05-28 17:00:11');
INSERT INTO `t_tenant_info` VALUES (450705076349046838, 'dev1118', '123', '1', '18823660118', 'dev118@qq.com', 0, '2020-05-28 17:01:04', '', '2020-05-28 17:01:04', '2020-05-28 17:01:04');
INSERT INTO `t_tenant_info` VALUES (450705350228709446, 'dev1109', '123', '1', '18823660109', 'dev109@qq.com', 0, '2020-05-28 17:02:09', '', '2020-05-28 17:02:09', '2020-05-28 17:02:09');
INSERT INTO `t_tenant_info` VALUES (450705645411242072, 'dev1538', '123', '1', '18823660538', 'dev538@qq.com', 0, '2020-05-28 17:03:20', '', '2020-05-28 17:03:20', '2020-05-28 17:03:20');
INSERT INTO `t_tenant_info` VALUES (450706274296795146, 'dev1393', '123', '1', '18823660393', 'dev393@qq.com', 0, '2020-05-28 17:05:50', '', '2020-05-28 17:05:50', '2020-05-28 17:05:50');
INSERT INTO `t_tenant_info` VALUES (450706692569567234, 'dev1189', '123', '1', '18823660189', 'dev189@qq.com', 0, '2020-05-28 17:07:29', '', '2020-05-28 17:07:29', '2020-05-28 17:07:29');
INSERT INTO `t_tenant_info` VALUES (450706892621090910, 'dev1127', '123', '1', '18823660127', 'dev127@qq.com', 0, '2020-05-28 17:08:17', '', '2020-05-28 17:08:17', '2020-05-28 17:08:17');
INSERT INTO `t_tenant_info` VALUES (450967791374176352, 'dev1663', '123', '1', '18823660663', 'dev663@qq.com', 0, '2020-05-29 10:25:00', '', '2020-05-29 10:25:00', '2020-05-29 10:25:00');
INSERT INTO `t_tenant_info` VALUES (450970236938621025, 'dev1849', '123', '1', '18823660849', 'dev849@qq.com', 0, '2020-05-29 10:34:43', '', '2020-05-29 10:34:43', '2020-05-29 10:34:43');
INSERT INTO `t_tenant_info` VALUES (450970608566538329, 'dev1749', '123', '1', '18823660749', 'dev749@qq.com', 1, '2020-05-29 10:36:12', '', '2020-05-29 10:36:12', '2020-05-29 10:36:12');
INSERT INTO `t_tenant_info` VALUES (450974450951655436, 'dev1652', '123', '1', '18823660652', 'dev652@qq.com', 1, '2020-05-29 10:51:28', '', '2020-05-29 10:51:28', '2020-05-29 10:51:28');

SET FOREIGN_KEY_CHECKS = 1;
