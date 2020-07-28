/*
Navicat MySQL Data Transfer

Source Server         : Li
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : bagevent_test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2020-07-28 18:46:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `userloginlog`
-- ----------------------------
DROP TABLE IF EXISTS `userloginlog`;
CREATE TABLE `userloginlog` (
  `login_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `login_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `login_ip` varchar(64) default NULL,
  PRIMARY KEY  (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userloginlog
-- ----------------------------
INSERT INTO `userloginlog` VALUES ('19', '3', '2020-07-26 00:00:00', null);
INSERT INTO `userloginlog` VALUES ('33', '3', '2020-07-26 18:51:14', null);
INSERT INTO `userloginlog` VALUES ('34', '14', '2020-07-26 19:07:17', null);
INSERT INTO `userloginlog` VALUES ('35', '15', '2020-07-26 21:59:42', null);
INSERT INTO `userloginlog` VALUES ('36', '17', '2020-07-26 23:07:22', null);
INSERT INTO `userloginlog` VALUES ('37', '17', '2020-07-26 23:08:13', null);
INSERT INTO `userloginlog` VALUES ('38', '18', '2020-07-27 21:35:20', null);
INSERT INTO `userloginlog` VALUES ('39', '18', '2020-07-27 21:40:15', null);
INSERT INTO `userloginlog` VALUES ('40', '18', '2020-07-27 21:41:11', null);
INSERT INTO `userloginlog` VALUES ('41', '20', '2020-07-28 02:12:17', null);
INSERT INTO `userloginlog` VALUES ('42', '21', '2020-07-28 02:24:53', null);
INSERT INTO `userloginlog` VALUES ('43', '20', '2020-07-28 02:36:03', null);
INSERT INTO `userloginlog` VALUES ('44', '22', '2020-07-28 18:21:07', null);
INSERT INTO `userloginlog` VALUES ('45', '23', '2020-07-28 18:22:30', null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(20) NOT NULL,
  `email` varchar(64) default NULL,
  `cellphone` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(20) default NULL,
  `state` int(2) NOT NULL,
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('16', '李女士', '1471105@qq.com', '17314985849', '81DC9BDB52D04DC20036DBD8313ED055l26q', 'l26q', '0', '2020-07-26 22:53:31');
INSERT INTO `users` VALUES ('17', '李先森', '1471105934@qq.com', '17314985849', '02E5F524F5BC784E1DE1B420F187C4C7', 't1fq', '0', '2020-07-26 23:04:14');
INSERT INTO `users` VALUES ('20', '天下第九', '11133@qq.com', '15555555554', 'EF7AB0213D22CFD01844688ECEFF7D82', 'xt99', '0', '2020-07-28 02:10:34');
INSERT INTO `users` VALUES ('21', '天下第三', '11134443@qq.com', '15555555554', '9B0B5CFB13553379EC02C3BFE3F92EC9', 'wanh', '0', '2020-07-28 02:24:45');
INSERT INTO `users` VALUES ('22', '李小篆', '1555@qq.com', '17314876583', '6EA1592AF5099DCC58BD6B9241738E48', 'mp51', '0', '2020-07-28 18:20:40');
INSERT INTO `users` VALUES ('23', '李细传', '727417486@qq.com', '17314985667', '0F12320D2DE6C255AB19EA4F4C9D5A5C', 'yyvn', '0', '2020-07-28 18:22:16');
INSERT INTO `users` VALUES ('24', '李细信', '72741486@qq.com', '17314985667', '639F2B58E04F84248DE5E8925F93AEEA', '99ab', '0', '2020-07-28 18:23:33');
