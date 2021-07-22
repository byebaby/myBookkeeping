-- --------------------------------------------------------
-- 主机:                           47.100.38.178
-- 服务器版本:                        10.4.8-MariaDB-1:10.4.8+maria~bionic - mariadb.org binary distribution
-- 服务器操作系统:                      debian-linux-gnu
-- HeidiSQL 版本:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  视图 test.asset_all_report_view 结构
DROP VIEW IF EXISTS `asset_all_report_view`;
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `asset_all_report_view` (
	`id` BIGINT(20) NOT NULL,
	`username` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`YEAR` VARCHAR(4) NULL COLLATE 'utf8mb4_general_ci',
	`income` DECIMAL(54,2) NULL,
	`net_assets` DECIMAL(33,2) NULL,
	`net_income` DECIMAL(34,2) NULL,
	`expense` DECIMAL(55,2) NULL
) ENGINE=MyISAM;

-- 导出  表 test.asset_detail 结构
DROP TABLE IF EXISTS `asset_detail`;
CREATE TABLE IF NOT EXISTS `asset_detail` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `amount` decimal(10,2) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `asset_main_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaid5xd3hmjuycs8scat8x619w` (`asset_main_id`),
  CONSTRAINT `FKaid5xd3hmjuycs8scat8x619w` FOREIGN KEY (`asset_main_id`) REFERENCES `asset_main` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.asset_detail 的数据：~24 rows (大约)
DELETE FROM `asset_detail`;
/*!40000 ALTER TABLE `asset_detail` DISABLE KEYS */;
INSERT INTO `asset_detail` (`id`, `created_date`, `last_modified_date`, `amount`, `message`, `type`, `asset_main_id`) VALUES
	(63, '2020-01-12 19:16:32.325000', '2020-01-12 19:16:32.325000', 500.00, '1银行', '资产', 62),
	(64, '2020-01-12 19:16:32.331000', '2020-01-12 19:16:32.331000', 400.00, '2银行', '资产', 62),
	(65, '2020-01-12 19:16:32.336000', '2020-01-12 19:16:32.336000', 200.00, '花呗', '负债', 62),
	(66, '2020-01-12 19:16:32.340000', '2020-01-12 19:16:32.340000', 500.00, '工资', '收入', 62),
	(68, '2020-01-12 19:16:51.556000', '2020-01-12 19:16:51.556000', 900.00, '1银行', '资产', 67),
	(69, '2020-01-12 19:16:51.562000', '2020-01-12 19:16:51.562000', 900.00, '2银行', '资产', 67),
	(70, '2020-01-12 19:16:51.567000', '2020-01-12 19:16:51.567000', 0.00, '花呗', '负债', 67),
	(71, '2020-01-12 19:16:51.569000', '2020-01-12 19:17:33.467000', 1500.00, '工资', '收入', 67),
	(124, '2020-10-21 10:16:45.063000', '2020-10-21 10:16:45.063000', 3239.85, '光大银行', '资产', 123),
	(125, '2020-10-21 10:16:45.065000', '2020-10-21 10:16:45.065000', 7286.66, '工资', '收入', 123),
	(126, '2020-10-21 10:16:45.075000', '2020-10-21 10:16:45.075000', 19279.68, '建设银行', '资产', 123),
	(127, '2020-10-21 10:16:45.077000', '2020-10-21 10:16:45.077000', 0.00, '广告-建设', '收入', 123),
	(128, '2020-10-21 10:16:45.080000', '2020-10-21 10:16:45.080000', 21.00, '工商银行', '资产', 123),
	(129, '2020-10-21 10:16:45.083000', '2020-10-21 10:16:45.083000', 0.00, '广告-工商', '收入', 123),
	(130, '2020-10-21 10:16:45.089000', '2020-10-21 10:16:45.089000', 397.82, '招商银行', '资产', 123),
	(131, '2020-10-21 10:16:45.091000', '2020-10-21 10:16:45.091000', 0.00, '广告-招商', '收入', 123),
	(132, '2020-10-21 10:16:45.093000', '2020-10-21 10:16:45.093000', 0.00, '借款', '资产', 123),
	(133, '2020-10-21 10:16:45.094000', '2020-10-21 10:16:45.094000', 34381.75, '基金', '资产', 123),
	(134, '2020-10-21 10:16:45.097000', '2020-10-21 10:16:45.097000', 17227.13, '股票', '资产', 123),
	(135, '2020-10-21 10:16:45.102000', '2020-10-21 10:16:45.102000', 0.00, '支付宝', '资产', 123),
	(136, '2020-10-21 10:16:45.104000', '2020-10-21 10:16:45.104000', 0.00, '微信', '资产', 123),
	(137, '2020-10-21 10:16:45.112000', '2020-10-21 10:16:45.112000', 0.00, '京东白条', '负债', 123),
	(138, '2020-10-21 10:16:45.114000', '2020-10-21 10:16:45.114000', 420.53, '花呗', '负债', 123),
	(139, '2020-10-21 10:16:45.122000', '2020-10-21 10:16:45.122000', 0.00, '房租', '支出', 123);
/*!40000 ALTER TABLE `asset_detail` ENABLE KEYS */;

-- 导出  表 test.asset_main 结构
DROP TABLE IF EXISTS `asset_main`;
CREATE TABLE IF NOT EXISTS `asset_main` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.asset_main 的数据：~3 rows (大约)
DELETE FROM `asset_main`;
/*!40000 ALTER TABLE `asset_main` DISABLE KEYS */;
INSERT INTO `asset_main` (`id`, `created_date`, `last_modified_date`, `create_date`, `user_id`) VALUES
	(62, '2020-01-12 19:16:32.306000', '2020-01-12 19:16:32.306000', '2020-01-12', 53),
	(67, '2020-01-12 19:16:51.550000', '2020-01-12 19:16:51.550000', '2020-02-29', 53),
	(123, '2020-10-21 10:16:44.998000', '2020-10-21 10:16:44.998000', '2020-10-21', 2);
/*!40000 ALTER TABLE `asset_main` ENABLE KEYS */;

-- 导出  表 test.asset_model 结构
DROP TABLE IF EXISTS `asset_model`;
CREATE TABLE IF NOT EXISTS `asset_model` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.asset_model 的数据：~20 rows (大约)
DELETE FROM `asset_model`;
/*!40000 ALTER TABLE `asset_model` DISABLE KEYS */;
INSERT INTO `asset_model` (`id`, `created_date`, `last_modified_date`, `message`, `type`, `user_name`, `order_num`) VALUES
	(14, '2019-10-13 17:08:40.181000', '2019-12-27 13:43:05.217000', '股票', '资产', 'admin', 11),
	(32, '2019-11-06 16:10:57.205000', '2019-12-27 13:43:05.223000', '房租', '支出', 'admin', 16),
	(46, '2019-06-25 09:22:53.343000', '2019-12-27 13:43:05.226000', '光大银行', '资产', 'admin', 1),
	(47, '2019-06-25 09:22:53.359000', '2019-12-27 13:43:05.228000', '花呗', '负债', 'admin', 15),
	(48, '2019-06-25 09:22:53.360000', '2019-12-27 13:43:05.230000', '建设银行', '资产', 'admin', 3),
	(49, '2019-06-25 09:22:53.361000', '2019-12-27 13:43:05.232000', '京东白条', '负债', 'admin', 14),
	(51, '2019-12-27 13:41:36.336000', '2019-12-27 13:43:05.236000', '招商银行', '资产', 'admin', 7),
	(52, '2019-12-27 13:41:36.448000', '2019-12-27 13:43:05.237000', '广告-招商', '收入', 'admin', 8),
	(57, '2019-06-25 10:36:22.238000', '2019-12-27 13:43:05.239000', '借款', '资产', 'admin', 9),
	(58, '2020-01-12 19:16:04.481000', '2020-01-12 19:16:04.481000', '1银行', '资产', 'a5512015', 1),
	(59, '2020-01-12 19:16:04.485000', '2020-01-12 19:16:04.485000', '2银行', '资产', 'a5512015', 2),
	(60, '2020-01-12 19:16:04.492000', '2020-01-12 19:16:04.492000', '花呗', '负债', 'a5512015', 3),
	(61, '2020-01-12 19:16:04.495000', '2020-01-12 19:16:04.495000', '工资', '收入', 'a5512015', 4),
	(1001, '2019-07-26 20:00:07.150000', '2019-12-27 13:43:05.239000', '基金', '资产', 'admin', 10),
	(1012, '2019-07-26 20:06:19.925000', '2019-12-27 13:43:05.242000', '微信', '资产', 'admin', 13),
	(1014, '2019-07-26 20:10:19.287000', '2019-12-27 13:43:05.244000', '工商银行', '资产', 'admin', 5),
	(2013, '2019-08-11 11:12:07.104000', '2019-12-27 13:43:05.247000', '支付宝', '资产', 'admin', 12),
	(2037, '2019-06-27 08:47:43.578000', '2019-12-27 13:43:05.249000', '工资', '收入', 'admin', 2),
	(2038, '2019-06-27 08:47:43.593000', '2019-12-27 13:43:05.251000', '广告-工商', '收入', 'admin', 6),
	(2039, '2019-06-27 08:47:43.594000', '2019-12-27 13:43:05.254000', '广告-建设', '收入', 'admin', 4);
/*!40000 ALTER TABLE `asset_model` ENABLE KEYS */;

-- 导出  视图 test.asset_view 结构
DROP VIEW IF EXISTS `asset_view`;
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `asset_view` (
	`id` BIGINT(20) NOT NULL,
	`user_id` BIGINT(20) NOT NULL,
	`username` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`create_date` DATE NULL,
	`assets` DECIMAL(32,2) NULL,
	`debt` DECIMAL(32,2) NULL,
	`income` DECIMAL(32,2) NULL
) ENGINE=MyISAM;

-- 导出  视图 test.asset_year_report_view 结构
DROP VIEW IF EXISTS `asset_year_report_view`;
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `asset_year_report_view` (
	`id` BIGINT(20) NOT NULL,
	`username` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`months` VARCHAR(7) NULL COLLATE 'utf8mb4_general_ci',
	`net_assets` DECIMAL(33,2) NULL,
	`net_income` DECIMAL(34,2) NULL,
	`income` DECIMAL(32,2) NULL,
	`expense` DECIMAL(35,2) NULL
) ENGINE=MyISAM;

-- 导出  表 test.hibernate_sequence 结构
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- 正在导出表  test.hibernate_sequence 的数据：~1 rows (大约)
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- 导出  表 test.menu_path 结构
DROP TABLE IF EXISTS `menu_path`;
CREATE TABLE IF NOT EXISTS `menu_path` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.menu_path 的数据：~4 rows (大约)
DELETE FROM `menu_path`;
/*!40000 ALTER TABLE `menu_path` DISABLE KEYS */;
INSERT INTO `menu_path` (`id`, `created_date`, `last_modified_date`, `name`, `path`, `sort`) VALUES
	(1, NULL, NULL, '资产', '/asset', 1),
	(2, NULL, NULL, '模板配置', '/asset/defaultModel', 1),
	(3, NULL, NULL, '资产负债表', '/asset/assetsView', 2),
	(4, NULL, NULL, '资产报表', '/asset/report', 3);
/*!40000 ALTER TABLE `menu_path` ENABLE KEYS */;

-- 导出  表 test.roles_permissions 结构
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE IF NOT EXISTS `roles_permissions` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `user_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg7uhxvivojs3dv5tyqp6e4hxr` (`user_role_id`),
  CONSTRAINT `FKg7uhxvivojs3dv5tyqp6e4hxr` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.roles_permissions 的数据：~0 rows (大约)
DELETE FROM `roles_permissions`;
/*!40000 ALTER TABLE `roles_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles_permissions` ENABLE KEYS */;

-- 导出  表 test.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.user 的数据：~3 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `created_date`, `last_modified_date`, `nick`, `password`, `password_salt`, `username`) VALUES
	(2, '2019-05-24 00:02:09.079000', '2019-05-24 00:02:09.079000', NULL, 'a82e5f9998a1e9493a1e2b7921fea1a8', 'moWTIFTQBRTimktj9D/bIA==', 'admin'),
	(53, '2020-01-12 19:15:04.496000', '2020-01-12 19:15:04.496000', NULL, '90a31a9e4b75356166ddf0d0fa0e249d', '6XmGMIKa0TlU0xPWuBEaFg==', 'a5512015'),
	(140, '2021-04-04 18:20:37.491000', '2021-04-04 18:20:37.491000', NULL, 'f0c57a28d2c4b9a02b9a29af9812cb3d', 's6LG1e5x9AvHdtRGGyeX5Q==', 'JustTes2020'),
	(1055, '2019-07-26 20:26:44.233000', '2019-07-26 20:26:44.233000', NULL, '6738b54c57641584756ad197459118ad', 'cEFE390uB/GPToXT7mtXNw==', 'a');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 test.user_role 结构
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.user_role 的数据：~0 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- 导出  视图 test.asset_all_report_view 结构
DROP VIEW IF EXISTS `asset_all_report_view`;
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `asset_all_report_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `asset_all_report_view` AS select `temp`.`id` AS `id`,`temp`.`username` AS `username`,`temp`.`YEAR` AS `YEAR`,`temp`.`income` AS `income`,`temp`.`net_assets` AS `net_assets`,`temp`.`net_assets` - `last_temp`.`net_assets` AS `net_income`,`temp`.`income` - (`temp`.`net_assets` - `last_temp`.`net_assets`) AS `expense` from ((select `b`.`id` AS `id`,`temp`.`username` AS `username`,`temp`.`YEAR` AS `YEAR`,`temp`.`income` AS `income`,`b`.`net_assets` AS `net_assets` from ((select `a`.`username` AS `username`,left(`a`.`months`,4) AS `YEAR`,max(`a`.`months`) AS `months`,sum(`a`.`income`) AS `income` from `test`.`asset_year_report_view` `a` group by left(`a`.`months`,4),`a`.`username`) `temp` join `test`.`asset_year_report_view` `b`) where `temp`.`months` = `b`.`months` and `temp`.`username` = `b`.`username`) `temp` left join (select `b`.`id` AS `id`,`temp`.`username` AS `username`,`temp`.`YEAR` AS `YEAR`,`temp`.`income` AS `income`,`b`.`net_assets` AS `net_assets` from ((select `a`.`username` AS `username`,left(`a`.`months`,4) AS `YEAR`,max(`a`.`months`) AS `months`,sum(`a`.`income`) AS `income` from `test`.`asset_year_report_view` `a` group by left(`a`.`months`,4),`a`.`username`) `temp` join `test`.`asset_year_report_view` `b`) where `temp`.`months` = `b`.`months` and `temp`.`username` = `b`.`username`) `last_temp` on(`temp`.`username` = `last_temp`.`username` and `temp`.`YEAR` = `last_temp`.`YEAR` + 1)) order by `temp`.`YEAR`;

-- 导出  视图 test.asset_view 结构
DROP VIEW IF EXISTS `asset_view`;
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `asset_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `asset_view` AS select `asset_main`.`id` AS `id`,`user`.`id` AS `user_id`,`user`.`username` AS `username`,`asset_main`.`create_date` AS `create_date`,sum(if(`asset_detail`.`type` = '资产',`asset_detail`.`amount`,0)) AS `assets`,sum(if(`asset_detail`.`type` = '负债',`asset_detail`.`amount`,0)) AS `debt`,sum(if(`asset_detail`.`type` = '收入',`asset_detail`.`amount`,0)) AS `income` from ((`user` join `asset_main`) join `asset_detail`) where `user`.`id` = `asset_main`.`user_id` and `asset_main`.`id` = `asset_detail`.`asset_main_id` group by `asset_main`.`id`;

-- 导出  视图 test.asset_year_report_view 结构
DROP VIEW IF EXISTS `asset_year_report_view`;
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `asset_year_report_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `asset_year_report_view` AS select `temp`.`id` AS `id`,`temp`.`username` AS `username`,date_format(`temp`.`months`,'%Y-%m') AS `months`,round(`temp`.`net_assets`,2) AS `net_assets`,round(`temp`.`net_assets` - `last_temp`.`net_assets`,2) AS `net_income`,round(`temp`.`income`,2) AS `income`,round(`temp`.`income` - (`temp`.`net_assets` - `last_temp`.`net_assets`),2) AS `expense` from ((select `asset_view`.`id` AS `id`,`asset_view`.`user_id` AS `user_id`,`asset_view`.`username` AS `username`,`asset_view`.`income` AS `income`,`asset_view`.`create_date` AS `months`,`asset_view`.`assets` - `asset_view`.`debt` AS `net_assets` from `test`.`asset_view` where `asset_view`.`id` in (select max(`asset_view`.`id`) AS `id` from `test`.`asset_view` group by date_format(`asset_view`.`create_date`,'%Y-%m')) order by `asset_view`.`create_date`) `temp` left join (select `asset_view`.`username` AS `username`,`asset_view`.`create_date` AS `months`,`asset_view`.`assets` - `asset_view`.`debt` AS `net_assets` from `test`.`asset_view` where `asset_view`.`id` in (select max(`asset_view`.`id`) AS `id` from `test`.`asset_view` group by date_format(`asset_view`.`create_date`,'%Y-%m')) order by `asset_view`.`create_date`) `last_temp` on(`temp`.`username` = `last_temp`.`username` and date_format(`temp`.`months`,'%Y-%m') = date_format(`last_temp`.`months` + interval 1 month,'%Y-%m'))) order by date_format(`temp`.`months`,'%Y-%m');

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
