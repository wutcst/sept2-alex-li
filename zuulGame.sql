/*
 Navicat Premium Data Transfer

 Source Server         : First
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : zuulGame

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 16/06/2023 13:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
BEGIN;
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (1, '宝剑', '这是一把大宝剑！', 40, 1, 'http://1.13.173.161:8080/images/W_Spear014.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (2, '卷轴', '这里描绘着技能', 20, 2, 'http://1.13.173.161:8080/images/I_Scroll.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (3, '盾牌', '这是具有防御属性的盾牌', 30, 2, 'http://1.13.173.161:8080/images/icon_11.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (4, '鞋子', '这是护具鞋子', 20, 3, 'http://1.13.173.161:8080/images/S_EVA.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (5, '项链', '这是一条魔法项链', 10, 5, ' http://1.13.173.161:8080/images/Ac_6.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (6, '戒指', '这是一枚魔法戒指', 10, 5, 'http://1.13.173.161:8080/images/Ac_10.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (7, '铠甲', '这是一身钢铁护具', 50, 8, 'http://1.13.173.161:8080/images/U_Armor07.png');
INSERT INTO `item` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (8, '布衣', '这是皮做的布衣', 20, 4, 'http://1.13.173.161:8080/images/A_A3.png');
COMMIT;

-- ----------------------------
-- Table structure for monster
-- ----------------------------
DROP TABLE IF EXISTS `monster`;
CREATE TABLE `monster` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `room_id` int(1) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monster
-- ----------------------------
BEGIN;
INSERT INTO `monster` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (1, '怪兽', '我是大BOSS！！！', 60, 9, 'http://1.13.173.161:8080/images/monster1.png');
INSERT INTO `monster` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (2, '果冻怪', '我是一只绿毛怪', 20, 1, 'http://1.13.173.161:8080/images/monster2.png');
INSERT INTO `monster` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (3, '龙龙', '我是龙龙小怪兽', 30, 2, 'http://1.13.173.161:8080/images/monster3.png');
INSERT INTO `monster` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (5, '蓝胖怪', '我是蓝胖怪', 20, 4, 'http://1.13.173.161:8080/images/monster4.png');
INSERT INTO `monster` (`id`, `name`, `des`, `value`, `room_id`, `img`) VALUES (6, '黄色小怪兽', '我是一只黄色小怪兽', 40, 6, 'http://1.13.173.161:8080/images/monster7.png');
COMMIT;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `current_Room` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player
-- ----------------------------
BEGIN;
INSERT INTO `player` (`id`, `username`, `password`, `value`, `current_Room`) VALUES (1, 'xidongdong', '123', '0', 1);
COMMIT;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) DEFAULT NULL,
  `north` int(11) DEFAULT NULL,
  `south` varchar(255) DEFAULT NULL,
  `east` varchar(255) DEFAULT NULL,
  `west` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
BEGIN;
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (1, 4, '0', '2', '0');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (2, 5, '0', '3', '1');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (3, 6, '0', '0', '2');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (4, 7, '1', '5', '0');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (5, 8, '2', '6', '4');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (6, 9, '3', '0', '5');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (7, 0, '4', '8', '0');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (8, 0, '5', '9', '7');
INSERT INTO `room` (`id`, `north`, `south`, `east`, `west`) VALUES (9, 0, '6', '0', '8');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
