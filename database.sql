/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : pao

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-05-25 15:24:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `customer_id` int NOT NULL,
  `iban` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('1', 'awdasdasd', '1999999');
INSERT INTO `accounts` VALUES ('2', 'ooooppp', '999');

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of audit
-- ----------------------------
INSERT INTO `audit` VALUES ('1', 'help', '2022-05-24 04:58:38');
INSERT INTO `audit` VALUES ('2', 'create_customer', '2022-05-24 04:58:38');
INSERT INTO `audit` VALUES ('3', 'exit', '2022-05-24 04:58:38');
INSERT INTO `audit` VALUES ('4', 'help', '2022-05-24 05:06:51');
INSERT INTO `audit` VALUES ('5', 'create_customer', '2022-05-24 05:06:51');
INSERT INTO `audit` VALUES ('6', 'exit', '2022-05-24 05:06:51');
INSERT INTO `audit` VALUES ('7', 'create_account', '2022-05-24 05:07:30');
INSERT INTO `audit` VALUES ('8', 'deposit', '2022-05-24 05:07:30');
INSERT INTO `audit` VALUES ('9', 'exit', '2022-05-24 05:07:30');
INSERT INTO `audit` VALUES ('10', '', '2022-05-24 06:06:29');
INSERT INTO `audit` VALUES ('11', 'view_customer', '2022-05-24 06:07:29');
INSERT INTO `audit` VALUES ('12', 'help', '2022-05-24 06:07:29');
INSERT INTO `audit` VALUES ('13', 'view_customer_accounts', '2022-05-24 06:07:29');
INSERT INTO `audit` VALUES ('14', 'help', '2022-05-24 06:12:16');
INSERT INTO `audit` VALUES ('15', 'create_customer', '2022-05-24 06:12:16');
INSERT INTO `audit` VALUES ('16', 'help', '2022-05-24 06:12:16');
INSERT INTO `audit` VALUES ('17', 'deposit', '2022-05-24 06:12:16');
INSERT INTO `audit` VALUES ('18', 'exit', '2022-05-24 06:12:16');
INSERT INTO `audit` VALUES ('19', 'help', '2022-05-24 06:14:01');
INSERT INTO `audit` VALUES ('20', 'view_customers', '2022-05-24 06:14:01');
INSERT INTO `audit` VALUES ('21', 'view_customer_accounts', '2022-05-24 06:14:01');

-- ----------------------------
-- Table structure for cards
-- ----------------------------
DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `iban` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `cvv` int DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cards
-- ----------------------------
INSERT INTO `cards` VALUES ('awdasdasd', '8316 8246 4239 7099', '676', '2022-05-24 04:41:37');
INSERT INTO `cards` VALUES ('ooooppp', '6332 8053 5410 2759', '760', '2022-05-24 05:07:38');

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `streetNo` int DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '12', '12', '23', '23', 'asd', '12', '12', '12');
INSERT INTO `customers` VALUES ('2', '123', '123', '123', '123', 'asd', 'asd', '123', '123');
INSERT INTO `customers` VALUES ('3', 'asdf', 'asdf', '23', '99988', 'Buc', 'Strdasdasd', '123', '123455');
INSERT INTO `customers` VALUES ('4', 'asdasd', 'ffff', '45', '454545', 'asd', 'asd', '2', '22323');

-- ----------------------------
-- Table structure for deposits
-- ----------------------------
DROP TABLE IF EXISTS `deposits`;
CREATE TABLE `deposits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iban` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `sum` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of deposits
-- ----------------------------
INSERT INTO `deposits` VALUES ('1', 'awdasdasd', 'asdasd', '1000000');
INSERT INTO `deposits` VALUES ('2', 'ooooppp', 'pppp', '999');
INSERT INTO `deposits` VALUES ('3', 'awdasdasd', 'asdf', '999999');
