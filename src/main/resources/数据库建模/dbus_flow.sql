/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.6.44-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `dbus_flow` */

DROP TABLE IF EXISTS `dbus_flow`;

CREATE TABLE `dbus_flow` (
  `flowId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `mode` int(11) NOT NULL COMMENT '存储类型(#PHOENIX  #NATIVE   #STRING,默认STRING)',
  `databaseName` varchar(50) NOT NULL COMMENT 'database',
  `tableName` varchar(50) NOT NULL COMMENT 'table',
  `hbaseTable` varchar(50) NOT NULL COMMENT 'hbaseTable',
  `family` varchar(50) NOT NULL COMMENT 'family',
  `uppercaseQualifier` tinyint(1) NOT NULL COMMENT '字段名转大写, 默认为true',
  `commitBatch` int(11) NOT NULL COMMENT '字段名转大写, 默认为true',
  `rowKey` varchar(100) NOT NULL COMMENT '组成rowkey的字段名，必须用逗号分隔',
  `status` int(11) NOT NULL COMMENT '状态:1-初始,2:就绪,3:运行',
  PRIMARY KEY (`flowId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dbus_flow` */

insert  into `dbus_flow`(`flowId`,`mode`,`databaseName`,`tableName`,`hbaseTable`,`family`,`uppercaseQualifier`,`commitBatch`,`rowKey`,`status`) values (1,0,'test','dajiangtai_orders','learing_flink:dajiangtai_orders','0',1,10,'orderId',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
