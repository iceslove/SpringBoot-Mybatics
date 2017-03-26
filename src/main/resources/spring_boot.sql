/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : localhost
 Source Database       : spring_boot

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : utf-8

 Date: 03/26/2017 23:56:24 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `sys_account_id` int(10) NOT NULL,
  `sys_account_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `sys_account_email` varchar(255) DEFAULT NULL,
  `sys_account_tel` varchar(255) NOT NULL,
  `sys_account_last_ip` varchar(255) DEFAULT NULL,
  `sys_account_localize` varchar(255) DEFAULT NULL,
  `sys_account_status` int(11) DEFAULT NULL,
  `sys_account_pic` varchar(255) DEFAULT NULL,
  `sys_account_addr` varchar(512) DEFAULT NULL,
  `sys_account_real_name` varchar(255) DEFAULT NULL,
  `sys_account_company` varchar(255) DEFAULT NULL,
  `sys_account_sex` int(4) DEFAULT '1',
  `sys_account_intro` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sys_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `account`
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('1', 'admin', 'liuhw1', 'xGPs0xv08UiwoZoZ8KlLY7b9uCtEssB0Koxq8v06CDxmVEFBNGlaRLLOQ4sO', 'liuhw@sdp.com', '15691499022', null, null, '0', '/upload/user_photo/WrHANoLJmY.png', '123', '管理员1', '12', '1', '今天天气不错！!', '2017-01-10 11:01:16', '2017-03-17 18:34:06'), ('2', 'superadmin', '$2y$10$HFYUM3nw2HX47dGBFKvfK.GMp9jPvpw.F1MpPY9cz0rD5JTmFXSze', 'QIW1gdKe5uFVk8BRopkZ0p4rlYGg6V8v0wX3vcrVE3zDpTjk0F8zPlGfK9sX', 'admin@allwaywin.com', '15691499002', null, null, '1', '/upload/user_photo/Rx55xRgVEq.jpg', null, '超级管理员', null, '1', '555666777', '2017-01-10 11:01:16', '2017-03-15 19:21:02'), ('3', 'wangxiong', '$2y$10$7A1ahVOb5HtKTlkNJn/J9.B4DJ/7EUVFcoqtJsrSDHWn5PEM/2IiG', '', '123@qq.com', '18591965516', null, null, '1', '3.jpg', null, '小王', null, '1', null, '2017-01-10 11:01:16', '2017-03-17 17:27:10'), ('4', 'test_seller', '$2y$10$SRBXcSMpwgxyzntmYrGU1OG6yzfA6yHbhjkyYECDRWuCTv/GWDI1u', '3ClzMgwF3M6K7Bf17XeagrTCmma8Ac3kaHGKcaVzjqkJyeoWzN9Wqua892x3', '345293340@qq.com', '15135168660', null, null, '1', '4.jpg', '陕西省西安市长安区', '测试人员1', null, '1', null, '2017-01-10 11:01:16', '2016-11-09 15:05:59'), ('5', 'test_reseller', '$2y$10$HFYUM3nw2HX47dGBFKvfK.GMp9jPvpw.F1MpPY9cz0rD5JTmFXSze', '', '345293341@qq.com', '15135168789', null, null, '1', '5.jpg', '陕西省西安市长安区韦曲西街', '测试人员2', null, '1', null, '2017-01-10 11:01:16', null), ('6', 'test_1', '$2y$10$HFYUM3nw2HX47dGBFKvfK.GMp9jPvpw.F1MpPY9cz0rD5JTmFXSze', null, '2', '15222222222', null, null, '1', null, null, '测试人员31', null, '1', null, '2017-01-10 11:01:16', null);
COMMIT;

-- ----------------------------
--  Table structure for `int_key`
-- ----------------------------
DROP TABLE IF EXISTS `int_key`;
CREATE TABLE `int_key` (
  `key_name` varchar(32) NOT NULL,
  `key_value` int(32) DEFAULT NULL,
  PRIMARY KEY (`key_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `int_key`
-- ----------------------------
BEGIN;
INSERT INTO `int_key` VALUES ('account', '18'), ('app', '13'), ('menu', '41'), ('s_group', '24'), ('s_position', '4'), ('s_role', '7');
COMMIT;

-- ----------------------------
--  Table structure for `login_token`
-- ----------------------------
DROP TABLE IF EXISTS `login_token`;
CREATE TABLE `login_token` (
  `token` varchar(100) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expired_at` timestamp NULL DEFAULT NULL,
  `check_result_code` varchar(32) DEFAULT NULL,
  `oauth_access_token` varchar(2048) DEFAULT NULL,
  `oauth_expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `menu_text` varchar(256) DEFAULT NULL,
  `menu_url` varchar(256) DEFAULT NULL,
  `menu_css` varchar(256) DEFAULT NULL,
  `menu_parent` int(11) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `menu_leaf` int(11) DEFAULT NULL,
  `menu_desc` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('1', '成员管理', '/admin/accounts', 'fa fa-users', '0', '2', '0', null), ('5', '系统配置', '', 'fa fa-cogs', '0', '6', '0', null), ('6', '角色管理', '/admin/roles', 'fa fa-user', '5', '1', '1', null), ('7', '组织管理', '/admin/groups', 'fa fa-group', '0', '5', '0', null), ('10', '菜单管理', '/admin/menus', 'fa fa-list', '5', '8', '1', null), ('31', '角色成员管理', '/admin/roleMember', 'fa fa-user', '5', '2', '1', null), ('32', '职位设定', '/admin/position', 'fa fa-user', '0', '6', '1', null), ('35', '首页', '/admin', 'fa fa-home', '0', '2', '1', null), ('36', '组织设定', '/admin/groups', 'fa fa-group', '7', '1', '1', null), ('37', '组织成员管理', '/admin/groupMembers ', 'fa fa-user-plus', '7', '2', '1', null);
COMMIT;

-- ----------------------------
--  Table structure for `oauth_access_tokens`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_tokens`;
CREATE TABLE `oauth_access_tokens` (
  `id` varchar(100) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scopes` text,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_access_tokens_user_id_index` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `oauth_auth_codes`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_auth_codes`;
CREATE TABLE `oauth_auth_codes` (
  `id` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `scopes` text,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `oauth_clients`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_clients`;
CREATE TABLE `oauth_clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `secret` varchar(100) NOT NULL,
  `redirect` text NOT NULL,
  `personal_access_client` tinyint(1) NOT NULL,
  `password_client` tinyint(1) NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_clients_user_id_index` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `oauth_clients`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_clients` VALUES ('1', null, 'Laravel Personal Access Client', 'zaukZ2LALXSP2M9dYH8rf6iYxMNPnMHzloHuokZJ', 'http://localhost', '1', '0', '0', '2016-10-24 15:42:03', '2016-10-24 15:42:03'), ('2', null, 'Laravel Password Grant Client', '8SgC1i6DKIYt9vacu0dhqe6kLgJqIEoplYEuuXvh', 'http://localhost', '0', '1', '0', '2016-10-24 15:42:04', '2016-10-24 15:42:04'), ('3', null, 'dudu-web-app', 'QPTPNmcB8eUBTaEvcGdnryt9nXuISxl833iFpZAy', 'http://localhost', '0', '1', '0', '2016-11-11 18:39:16', '2016-11-11 18:39:16'), ('4', null, 'android_app', 'R9fDrJqz7rcttSAAYLhhJEUzTDnW1OOnxnVHSOJ4', 'http://localhost/auth/callback', '0', '1', '0', '2017-03-17 13:09:33', '2017-03-17 13:09:33');
COMMIT;

-- ----------------------------
--  Table structure for `oauth_personal_access_clients`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_personal_access_clients`;
CREATE TABLE `oauth_personal_access_clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_personal_access_clients_client_id_index` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `oauth_personal_access_clients`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_personal_access_clients` VALUES ('1', '1', '2016-10-24 15:42:03', '2016-10-24 15:42:03');
COMMIT;

-- ----------------------------
--  Table structure for `oauth_refresh_tokens`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_tokens`;
CREATE TABLE `oauth_refresh_tokens` (
  `id` varchar(100) NOT NULL,
  `access_token_id` varchar(100) NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_refresh_tokens_access_token_id_index` (`access_token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `s_group`
-- ----------------------------
DROP TABLE IF EXISTS `s_group`;
CREATE TABLE `s_group` (
  `s_group_id` int(8) NOT NULL,
  `s_group_name` varchar(256) DEFAULT NULL,
  `s_group_type_id` int(11) DEFAULT NULL,
  `s_group_left` int(11) DEFAULT NULL,
  `s_group_right` int(8) DEFAULT NULL,
  `s_group_parent` int(8) DEFAULT NULL,
  `s_group_level` int(8) DEFAULT NULL,
  `s_group_leaf` int(4) DEFAULT '1',
  `s_group_path` varchar(1024) DEFAULT '',
  `s_group_desc` varchar(512) DEFAULT '',
  `s_group_status` int(4) DEFAULT NULL,
  `s_group_fixed` int(4) DEFAULT '0',
  `s_group_code` varchar(512) DEFAULT '',
  `s_group_order` int(4) DEFAULT NULL,
  `s_group_sort` varchar(512) DEFAULT '',
  `create_by` int(4) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`s_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `s_group`
-- ----------------------------
BEGIN;
INSERT INTO `s_group` VALUES ('1', '卓晟信息科技', '1', '1', '12', '0', '1', '0', '', '', null, '0', '', null, '', null, null, null, null), ('2', '组织部', '1', '2', '3', '1', '2', '0', '~卓晟信息科技', '', '1', '0', '', null, '', null, null, null, null), ('3', '宣传部', '1', '4', '5', '1', '2', '0', '~卓晟信息科技', '', '1', '0', '', null, '', null, null, null, null), ('5', '市场部', '1', '6', '7', '1', '2', '0', '~卓晟信息科技', '', '1', '0', '', null, '', null, null, null, null), ('6', '开发部', '1', '8', '11', '1', '2', '0', '~卓晟信息科技', '', '1', '0', '', null, '', null, null, null, null), ('8', '开发2组', '1', '9', '10', '6', '3', '0', '~卓晟信息科技~开发部', '', '1', '0', '', null, '', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `s_group_member`
-- ----------------------------
DROP TABLE IF EXISTS `s_group_member`;
CREATE TABLE `s_group_member` (
  `s_group_id` int(4) NOT NULL,
  `sys_account_id` int(8) NOT NULL,
  `s_group_member_remark` varchar(512) DEFAULT NULL,
  `s_group_member_fixed` int(11) unsigned DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `create_by` int(8) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `update_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`s_group_id`,`sys_account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `s_group_member`
-- ----------------------------
BEGIN;
INSERT INTO `s_group_member` VALUES ('2', '2', null, '0', null, null, null, null), ('2', '1', null, '0', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `s_group_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_group_type`;
CREATE TABLE `s_group_type` (
  `s_group_type_id` int(4) NOT NULL DEFAULT '0',
  `s_group_type_title` varchar(128) NOT NULL,
  `s_group_type_desc` varchar(512) DEFAULT NULL,
  `s_group_type_showIf` int(4) DEFAULT NULL,
  PRIMARY KEY (`s_group_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `s_group_type`
-- ----------------------------
BEGIN;
INSERT INTO `s_group_type` VALUES ('1', '公司', '', '1'), ('2', '组织', '', '1'), ('3', '小组', ' ', '1');
COMMIT;

-- ----------------------------
--  Table structure for `s_member_grant`
-- ----------------------------
DROP TABLE IF EXISTS `s_member_grant`;
CREATE TABLE `s_member_grant` (
  `sys_account_id` int(4) NOT NULL DEFAULT '0',
  `s_group_grant` int(4) NOT NULL DEFAULT '0',
  `s_group_grant_path` varchar(512) DEFAULT NULL,
  `create_by` int(4) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `update_by` int(4) DEFAULT NULL,
  `updated_by` datetime DEFAULT NULL,
  PRIMARY KEY (`sys_account_id`,`s_group_grant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `s_member_grant`
-- ----------------------------
BEGIN;
INSERT INTO `s_member_grant` VALUES ('1', '2', null, null, null, null, null), ('1', '5', null, null, null, null, null), ('2', '2', null, null, null, null, null), ('2', '22', null, null, null, null, null), ('3', '2', null, null, null, null, null), ('4', '11', null, null, null, null, null), ('4', '12', null, null, null, null, null), ('5', '6', null, null, null, null, null), ('5', '23', null, null, null, null, null), ('5', '24', null, null, null, null, null), ('6', '17', null, null, null, null, null), ('7', '20', null, null, null, null, null), ('8', '18', null, null, null, null, null), ('8', '19', null, null, null, null, null), ('9', '22', null, null, null, null, null), ('10', '24', null, null, null, null, null), ('14', '22', null, null, null, null, null), ('14', '23', null, null, null, null, null), ('16', '25', null, null, null, null, null), ('16', '26', null, null, null, null, null), ('17', '27', null, null, null, null, null), ('17', '28', null, null, null, null, null), ('18', '29', null, null, null, null, null), ('18', '30', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `s_role_id` int(11) NOT NULL,
  `s_role_name` varchar(256) NOT NULL,
  `s_role_desc` varchar(512) NOT NULL,
  `s_role_order` int(11) NOT NULL,
  `s_role_status` int(11) NOT NULL DEFAULT '1',
  `s_role_fixed` int(4) DEFAULT '0',
  `create_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`s_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `s_role`
-- ----------------------------
BEGIN;
INSERT INTO `s_role` VALUES ('1', '管理员', '管理员', '1', '1', '1', '0', '0', null, null), ('2', '超级管理员', '超级管理员', '2', '1', '1', '0', '0', null, null), ('3', '普通用户', '普通用户', '3', '1', '1', '0', '0', null, null), ('4', '数据库管理员', '数据库管理员', '4', '1', '1', '0', '0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `s_role_member`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_member`;
CREATE TABLE `s_role_member` (
  `s_role_id` int(11) DEFAULT NULL,
  `sys_account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `s_role_member`
-- ----------------------------
BEGIN;
INSERT INTO `s_role_member` VALUES ('2', '2'), ('1', '4'), ('1', '2'), ('1', '1'), ('1', '14'), ('1', '3');
COMMIT;

-- ----------------------------
--  Table structure for `s_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_menu`;
CREATE TABLE `s_role_menu` (
  `s_role_id` int(4) NOT NULL DEFAULT '0',
  `menu_id` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`menu_id`,`s_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
--  Records of `s_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `s_role_menu` VALUES ('1', '1'), ('2', '1'), ('4', '1'), ('2', '5'), ('2', '6'), ('4', '6'), ('1', '7'), ('2', '7'), ('2', '8'), ('4', '8'), ('2', '10'), ('3', '11'), ('3', '12'), ('3', '13'), ('2', '14'), ('3', '22'), ('3', '23'), ('3', '24'), ('2', '31'), ('1', '32'), ('2', '32'), ('1', '33'), ('2', '33'), ('2', '34'), ('4', '34'), ('1', '35'), ('2', '35'), ('1', '36'), ('2', '36'), ('1', '37'), ('2', '37');
COMMIT;

-- ----------------------------
--  Table structure for `s_role_right`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_right`;
CREATE TABLE `s_role_right` (
  `s_role_id` int(11) NOT NULL,
  `sys_mod_id` int(11) NOT NULL DEFAULT '0',
  `sys_mod_func_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`s_role_id`,`sys_mod_id`,`sys_mod_func_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
--  Records of `s_role_right`
-- ----------------------------
BEGIN;
INSERT INTO `s_role_right` VALUES ('1', '1', '1'), ('1', '1', '2'), ('1', '1', '3'), ('1', '2', '2'), ('2', '1', '1'), ('2', '1', '2'), ('2', '1', '3'), ('2', '3', '1'), ('2', '3', '2'), ('2', '4', '1'), ('2', '5', '1'), ('2', '6', '1'), ('4', '1', '1'), ('4', '1', '2');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'shaoyun', 'shaoyun@yeah.net', '$2y$10$Df9A5dweroXbPsz2cIici.dEB9NCyLl8vJxyLGDvCxJYhXHVKMpP.', '50nXBT7wNqGJvapbF3zhpsEvN9HV80bAiko5IcB8GK4NfBpccI4AyK83LGeZ', '2016-10-24 10:24:11', '2016-10-25 14:01:41'), ('2', 'wx', 'wx', '$2y$10$rWNjx95CpLa.hehPd06VAuEEx0qI5hMp2Vvr5fgZ2VYvDbrxD4g12', 'YJ0ixVUuT3i9xVOSOI6VVIEks1uWMyQpuZQObF35ank2tMXQIMCcRxT9H3pM', '2016-10-24 13:25:42', '2016-10-24 17:55:55');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
