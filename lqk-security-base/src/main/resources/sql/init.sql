-- --------------------------------------------------------
-- 主机:                           10.18.3.178
-- 服务器版本:                        5.7.12 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5151
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 mp.tbl_sys_role 结构
DROP TABLE IF EXISTS `tbl_sys_role`;
CREATE TABLE IF NOT EXISTS `tbl_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  mp.tbl_sys_role 的数据：~2 rows (大约)
DELETE FROM `tbl_sys_role`;
/*!40000 ALTER TABLE `tbl_sys_role` DISABLE KEYS */;
INSERT INTO `tbl_sys_role` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `tbl_sys_role` ENABLE KEYS */;

-- 导出  表 mp.tbl_sys_user 结构
DROP TABLE IF EXISTS `tbl_sys_user`;
CREATE TABLE IF NOT EXISTS `tbl_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  mp.tbl_sys_user 的数据：~2 rows (大约)
DELETE FROM `tbl_sys_user`;
/*!40000 ALTER TABLE `tbl_sys_user` DISABLE KEYS */;
INSERT INTO `tbl_sys_user` (`id`, `username`, `password`) VALUES
	(1, 'admin', 'admin'),
	(2, 'abc', 'abc');
/*!40000 ALTER TABLE `tbl_sys_user` ENABLE KEYS */;

-- 导出  表 mp.tbl_sys_user_roles 结构
DROP TABLE IF EXISTS `tbl_sys_user_roles`;
CREATE TABLE IF NOT EXISTS `tbl_sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_user_id` (`sys_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  mp.tbl_sys_user_roles 的数据：~2 rows (大约)
DELETE FROM `tbl_sys_user_roles`;
/*!40000 ALTER TABLE `tbl_sys_user_roles` DISABLE KEYS */;
INSERT INTO `tbl_sys_user_roles` (`id`, `sys_user_id`, `roles_id`) VALUES
	(1, 1, 1),
	(2, 2, 2);
/*!40000 ALTER TABLE `tbl_sys_user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
