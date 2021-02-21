/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `rent_crawler` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rent_crawler`;

CREATE TABLE IF NOT EXISTS `house_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `house_title` varchar(100) DEFAULT NULL COMMENT '房屋标题',
  `house_pay` varchar(30) DEFAULT NULL COMMENT '房屋租金',
  `house_pay_way` varchar(30) DEFAULT NULL COMMENT '租金支付方式',
  `rent_way` varchar(30) DEFAULT NULL COMMENT '租赁方式',
  `house_type` varchar(30) DEFAULT NULL COMMENT '房屋类型',
  `toward_floor` varchar(30) DEFAULT NULL COMMENT '房屋朝向楼层',
  `house_estate` varchar(30) DEFAULT NULL COMMENT '所在小区',
  `area` varchar(30) DEFAULT NULL COMMENT '所属区域',
  `address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `pic` varchar(4000) DEFAULT NULL COMMENT '房屋图片',
  `time` varchar(20) DEFAULT NULL COMMENT '房屋最近发布时间',
  `agent_name` varchar(30) DEFAULT NULL COMMENT '房屋所属',
  `house_disposal` varchar(200) DEFAULT NULL COMMENT '房屋配置',
  `house_spot` varchar(200) DEFAULT NULL COMMENT '房屋亮点',
  `house_desc` text DEFAULT NULL COMMENT '房屋描述',
  `url` varchar(1000) NOT NULL COMMENT '详情页地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2097 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
