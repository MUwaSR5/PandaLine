/*
 Navicat Premium Data Transfer

 Source Server         : PandaLine
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : panda_line

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 15/07/2024 19:30:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cus_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户代码',
  `load_way` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '货物装卸方式',
  `collect_time` datetime(6) NULL DEFAULT NULL COMMENT '集荷时间',
  `collect_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '集荷地点',
  `send_time` datetime(6) NULL DEFAULT NULL COMMENT '发货时间',
  `send_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '发货地址',
  `car_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '车辆类型',
  `update_time` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
  `remark_message` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '备注信息',
  `thing_no` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '货物管理番号',
  `thing_message` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '货物信息',
  `fba_code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'FBA预约码',
  `fba_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'FBA预约id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5085 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '5006', 'XXX', '2027-07-08 00:00:00.000000', 'XXX', '2027-07-09 00:00:00.000000', 'XXX', 'XXX', '2024-07-13 10:59:29.077420', 'XXX', 'XXX', 'XXX', 'XXX', 'XXX');
INSERT INTO `task` VALUES (2, '5006', '0', '2024-07-10 00:00:00.000000', '浦安', '2024-07-11 00:00:00.000000', 'TPB3兵库县', '4T', '2024-07-10 18:54:10.147066', '上午纳品', '5081-20240709', '800件，20立方，7.3吨', 'FBA15DY5Y3JF', '19489894296');
INSERT INTO `task` VALUES (3, '5006', 'TEST', '2024-07-10 00:00:00.000000', 'TEST', '2024-07-10 00:00:00.000000', 'TEST', 'TEST', NULL, 'TEST', 'TEST', 'TEST', 'TEST', 'TEST');
INSERT INTO `task` VALUES (5, '5006', 'test', '2024-07-10 00:00:00.000000', 'test', '2024-07-10 00:00:00.000000', 'test', 'test', NULL, 'test', 'test', 'test', 'test', 'test');
INSERT INTO `task` VALUES (6, '5006', 'aa', '2024-07-02 00:00:00.000000', 'aa', '2024-07-02 00:00:00.000000', 'aa', 'aa', NULL, 'aa', 'aa', 'aa', 'aa', 'aa');
INSERT INTO `task` VALUES (7, '5006', 'bb', '2024-07-02 00:00:00.000000', 'bb', '2024-07-02 00:00:00.000000', 'bb', 'bb', NULL, 'bb', 'bb', 'bb', 'bb', 'bb');
INSERT INTO `task` VALUES (8, '5006', 'cc', '2024-07-02 00:00:00.000000', 'cc', '2024-07-02 00:00:00.000000', 'cc', 'cc', NULL, 'cc', 'cc', 'cc', 'cc', 'cc');
INSERT INTO `task` VALUES (9, '5006', 'dd', '2024-07-02 00:00:00.000000', 'dd', '2024-07-02 00:00:00.000000', 'dd', 'dd', '2024-07-10 20:39:27.000000', 'dd', 'dd', 'dd', 'dd', 'dd');
INSERT INTO `task` VALUES (10, '5006', 'XM1111', '2024-07-15 00:00:00.000000', 'XM1111', '2024-07-15 00:00:00.000000', 'XM11112', 'XM11112', '2024-07-14 11:44:35.061063', 'XM1111', 'XM1111', 'XM1111', 'XM1111', 'XM1111');
INSERT INTO `task` VALUES (5084, '5006', '托盘', '2024-07-16 00:00:00.000000', '〒135-0064 東京都江東区青海三丁目2番17号 ワールド流通センター（69-75）伊势湾 +81-8033155581  千枝-修改', '2024-07-16 00:00:00.000000', '〒277-0931 千葉県柏市藤ヶ谷1823ナカノ商会柏沼南物 流センター（アマゾンVF：VJNA） 080-7848-7949-修改', '10T-修改', '2024-07-15 13:38:32.119022', '-修改', '5081-20240717-修改', '5081-20240717-修改', '600箱，30方，9000kg-修改', '19526574296-修改');
INSERT INTO `task` VALUES (5087, '5006', 'uuuuuuuuuuuuuuuu', '2024-07-15 00:00:00.000000', '', '2024-07-14 00:00:00.000000', 'uuuuuuuuuuuuuuuu', 'uuuuuuuuuuuuuuuu', '2024-07-15 17:50:29.000000', 'uuuuuuuuuuuuuuuu', 'uuuuuuuuuuuuuuuu', 'uuuuuuuuuuuuuuuu', 'uuuuuuuuuuuuuuuu', 'uuuuuuuuuuuuuuuu');
INSERT INTO `task` VALUES (5088, '5006', 'iiiiiiiiiiiiiiii', '2024-07-28 00:00:00.000000', '', '2024-07-18 00:00:00.000000', 'iiiiiiiiiiiiiiii', 'iiiiiiiiiiiiiiii', '2024-07-15 18:08:11.376904', 'iiiiiiiiiiiiiiii', 'iiiiiiiiiiiiiiii', 'iiiiiiiiiiiiiiii', 'iiiiiiiiiiiiiiii', 'iiiiiiiiiiiiiiii');
INSERT INTO `task` VALUES (5089, '5006', 'yyyyyyyyyyyyyy', '2024-08-11 00:00:00.000000', 'yyyyyyyyyyyyyy', '2024-08-03 00:00:00.000000', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyy', '2024-07-15 18:11:51.734093', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyy');
INSERT INTO `task` VALUES (5090, '5006', 'zcxzczxcxzcz', '2024-07-06 00:00:00.000000', 'zcxzczxcxzcz', '2024-08-03 00:00:00.000000', 'zcxzczxcxzcz', 'zcxzczxcxzcz', '2024-07-15 18:15:53.000000', 'zcxzczxcxzcz', 'zcxzczxcxzcz', 'zcxzczxcxzcz', 'zcxzczxcxzcz', 'zcxzczxcxzcz');
INSERT INTO `task` VALUES (5091, '5006', 'ffafsa', '2024-07-06 00:00:00.000000', 'ffafsa', '2024-07-12 00:00:00.000000', 'ffafsa', 'ffafsa', '2024-07-15 18:47:59.000000', 'ffafsa', 'ffafsa', 'ffafsa', 'ffafsa', 'ffafsa');
INSERT INTO `task` VALUES (5092, '5006', 'jflkdsjhfds', '2024-12-29 00:00:00.000000', '', '2025-03-08 00:00:00.000000', 'jflkdsjhfds', 'jflkdsjhfds', NULL, 'jflkdsjhfds', 'jflkdsjhfds', 'jflkdsjhfds', 'jflkdsjhfds', 'jflkdsjhfds');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `cus_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '5214', '5214', '2024-07-02 13:27:49');
INSERT INTO `user` VALUES (6, 'pandaLine', 'pandaLine', '2024-07-14 13:21:40');
INSERT INTO `user` VALUES (7, '5080', '5080', NULL);
INSERT INTO `user` VALUES (16, '888855', '8888555', '2024-07-14 20:33:18');
INSERT INTO `user` VALUES (22, '5006', '5006', NULL);
INSERT INTO `user` VALUES (23, '5172', '5172', NULL);
INSERT INTO `user` VALUES (25, '8888888', 'pandaLine', NULL);
INSERT INTO `user` VALUES (26, '55555551', '55555551', '2024-07-15 17:45:30');

SET FOREIGN_KEY_CHECKS = 1;
