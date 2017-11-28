/*
SQLyog Enterprise - MySQL GUI v6.06
Host - 5.0.90-community-nt : Database - jxjsfk
*********************************************************************
Server version : 5.0.90-community-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `jxjsfk`;

USE `jxjsfk`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `ice_cream_bar` */

DROP TABLE IF EXISTS `ice_cream_bar`;

CREATE TABLE `ice_cream_bar` (
  `Id` int(11) NOT NULL auto_increment,
  `origin_place` varchar(255) default NULL,
  `production_place` varchar(255) default NULL,
  `choose_place` varchar(255) default NULL,
  `processing_place` varchar(255) default NULL,
  `leave_factory` varchar(255) default NULL,
  `products_id` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ice_cream_bar` */

insert  into `ice_cream_bar`(`Id`,`origin_place`,`production_place`,`choose_place`,`processing_place`,`leave_factory`,`products_id`) values (1,'大兴安岭999','赤峰','呼和浩特','包头','鄂尔多斯','D1234567');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `mid` int(11) NOT NULL auto_increment,
  `mname` varchar(30) default NULL,
  `mstatus` int(1) default NULL,
  `mcid` int(1) default NULL,
  `mpass` varchar(32) default NULL,
  `mremark` varchar(255) default NULL,
  `msex` int(1) default NULL,
  `mmonth` int(1) default NULL,
  `mday` int(1) default NULL,
  `mphone` int(1) default NULL,
  `maddress` varchar(100) default NULL,
  `mother` varchar(100) default NULL,
  `mjoin` datetime default NULL,
  `midcard` varchar(18) default NULL,
  `mbalance` float default NULL,
  `mpoint` int(4) default NULL,
  `mlastime` varchar(100) default NULL,
  PRIMARY KEY  (`mid`)
) ENGINE=MyISAM AUTO_INCREMENT=1587 DEFAULT CHARSET=gbk;

/*Data for the table `member` */

insert  into `member`(`mid`,`mname`,`mstatus`,`mcid`,`mpass`,`mremark`,`msex`,`mmonth`,`mday`,`mphone`,`maddress`,`mother`,`mjoin`,`midcard`,`mbalance`,`mpoint`,`mlastime`) values (1001,'高丽丽',0,1,'**','记次卡',0,6,8,2147483647,'北京','其他','2014-08-09 00:00:00','152634197809081425',9969.6,2,'20120606'),(1586,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,203,NULL,NULL);

/*Table structure for table `real_time` */

DROP TABLE IF EXISTS `real_time`;

CREATE TABLE `real_time` (
  `seq_no` int(11) NOT NULL auto_increment,
  `st_no` varchar(20) NOT NULL,
  `st_name` varchar(30) NOT NULL,
  `course_name` varchar(50) NOT NULL,
  `problem_no` varchar(20) NOT NULL,
  `class_no` varchar(20) NOT NULL,
  `score` float(2,1) default NULL,
  `result_flag` int(1) default NULL,
  `select_answer` char(8) NOT NULL,
  `answer_time` datetime NOT NULL,
  `mac_id` int(3) NOT NULL,
  `remark_1` varchar(50) default NULL,
  `remark_2` varchar(50) default NULL,
  `remark_3` varchar(50) default NULL,
  PRIMARY KEY  (`seq_no`),
  KEY `st_no` (`st_no`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

/*Data for the table `real_time` */

/*Table structure for table `real_time_temp` */

DROP TABLE IF EXISTS `real_time_temp`;

CREATE TABLE `real_time_temp` (
  `seq_no` int(11) NOT NULL auto_increment,
  `st_no` varchar(20) NOT NULL,
  `st_name` varchar(30) NOT NULL,
  `course_name` varchar(50) NOT NULL,
  `problem_no` varchar(20) NOT NULL,
  `class_no` varchar(20) NOT NULL,
  `score` float(2,1) default NULL,
  `result_flag` int(1) default NULL,
  `select_answer` char(8) NOT NULL,
  `answer_time` datetime NOT NULL,
  `mac_id` int(3) NOT NULL,
  `remark_1` varchar(50) default NULL,
  `remark_2` varchar(50) default NULL,
  `remark_3` varchar(50) default NULL,
  PRIMARY KEY  (`seq_no`),
  KEY `st_no` (`st_no`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

/*Data for the table `real_time_temp` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `seq_no` int(11) default '0',
  `st_no` varchar(20) NOT NULL,
  `st_name` varchar(30) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `birthday` date NOT NULL,
  `class_no` varchar(10) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `address` varchar(60) NOT NULL,
  `phone` varchar(15) default NULL,
  `mobile` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  `regist_flg` int(2) default NULL,
  `remark` varchar(100) NOT NULL default '0',
  PRIMARY KEY  (`st_no`),
  KEY `student_index1` (`st_no`,`st_name`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

/*Data for the table `student` */

insert  into `student`(`seq_no`,`st_no`,`st_name`,`sex`,`birthday`,`class_no`,`grade`,`address`,`phone`,`mobile`,`email`,`regist_flg`,`remark`) values (0,'','高俊','','0000-00-00','1','六年级','',NULL,NULL,NULL,NULL,'0'),(0,'1','王丽','男 ','0000-00-00','1','六年级','呼和浩特',NULL,NULL,NULL,NULL,'0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
