/*
 Navicat Premium Data Transfer

 Source Server         : mysql_1
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : gl52

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/05/2021 02:44:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DOCUMENT
-- ----------------------------
DROP TABLE IF EXISTS `DOCUMENT`;
CREATE TABLE `DOCUMENT` (
  `DOCUMENT_ID` int NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int NOT NULL,
  `DOCUMENT_TITLE` varchar(32) NOT NULL,
  `DOCUMENT_TYPE` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DOCUMENT_CREATION` datetime DEFAULT NULL,
  `DOCUMENT_MODIFICATION` datetime DEFAULT NULL,
  `DOCUMENT_CONTENT` longblob,
  PRIMARY KEY (`DOCUMENT_ID`),
  KEY `FK_DOCUMENT_PROJECT` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for MEETING
-- ----------------------------
DROP TABLE IF EXISTS `MEETING`;
CREATE TABLE `MEETING` (
  `PROJECT_ID` int DEFAULT NULL,
  `MEETING_START` datetime NOT NULL,
  `MEETING_END` datetime NOT NULL,
  `MEETING_ID` int NOT NULL AUTO_INCREMENT,
  `SUPERVISOR_ID` int DEFAULT NULL,
  PRIMARY KEY (`MEETING_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for PROJECT
-- ----------------------------
DROP TABLE IF EXISTS `PROJECT`;
CREATE TABLE `PROJECT` (
  `PROJECT_ID` int NOT NULL AUTO_INCREMENT,
  `SUBJECT_ID` int DEFAULT NULL,
  `SUPERVISOR_ID` int DEFAULT NULL,
  `PROJECT_TITLE` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROJECT_GRADE` int DEFAULT NULL,
  `PROJECT_COMMENTS` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_ID`),
  KEY `FK_PROJECT_SUBJECT` (`SUBJECT_ID`),
  KEY `FK_PROJECT_USER` (`SUPERVISOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for SUBJECT
-- ----------------------------
DROP TABLE IF EXISTS `SUBJECT`;
CREATE TABLE `SUBJECT` (
  `SUBJECT_ID` int NOT NULL AUTO_INCREMENT,
  `SUBJECT_NAME` varchar(128) NOT NULL,
  `SUBJECT_DESCRIPTION` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`SUBJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `USER_FIRSTNAME` varchar(32) NOT NULL,
  `USER_LASTNAME` varchar(32) NOT NULL,
  `USER_EMAIL` varchar(128) NOT NULL,
  `USER_PASSWORD` varchar(128) NOT NULL,
  `USER_TYPE` char(1) NOT NULL,
  `PROJECT_ID` int DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for WORK
-- ----------------------------
DROP TABLE IF EXISTS `WORK`;
CREATE TABLE `WORK` (
  `USER_ID` int NOT NULL,
  `PROJECT_ID` int NOT NULL,
  `WORK_ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`WORK_ID`) USING BTREE,
  KEY `FK_WORK_PROJECT` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
