-- --------------------------------------------------------
-- 主机:                           192.168.31.137
-- 服务器版本:                        5.7.25-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 admin 的数据库结构
DROP DATABASE IF EXISTS `admin`;
CREATE DATABASE IF NOT EXISTS `admin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `admin`;

-- 导出  表 admin.hibernate_sequence 结构
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.hibernate_sequence 的数据：1 rows
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- 导出  表 admin.t_admin_model 结构
DROP TABLE IF EXISTS `t_admin_model`;
CREATE TABLE IF NOT EXISTS `t_admin_model` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_admin_model 的数据：0 rows
/*!40000 ALTER TABLE `t_admin_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_model` ENABLE KEYS */;

-- 导出  表 admin.t_email_config 结构
DROP TABLE IF EXISTS `t_email_config`;
CREATE TABLE IF NOT EXISTS `t_email_config` (
  `id` bigint(20) NOT NULL,
  `from_user` varchar(255) DEFAULT NULL,
  `host` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `port` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_email_config 的数据：0 rows
/*!40000 ALTER TABLE `t_email_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_email_config` ENABLE KEYS */;

-- 导出  表 admin.t_log 结构
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE IF NOT EXISTS `t_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `log_type` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `params` text,
  `request_ip` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_log 的数据：0 rows
/*!40000 ALTER TABLE `t_log` DISABLE KEYS */;
INSERT INTO `t_log` (`id`, `address`, `browser`, `create_time`, `description`, `exception_detail`, `log_type`, `method`, `params`, `request_ip`, `time`, `username`) VALUES
	(1, '内网IP', 'Chrome 8', '2020-04-27 09:13:07', '用户登录', NULL, 'INFO', 'com.lcyan.admin.app.boot.security.rest.AuthorizationController.login()', '{ authUser: {username=admin, password= ******} request: SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@4876affb] }', '0:0:0:0:0:0:0:1', 1153, 'admin'),
	(2, '内网IP', 'Chrome 8', '2020-04-27 09:13:25', '查询用户', NULL, 'INFO', 'com.lcyan.admin.app.service.system.controller.UserController.getUsers()', '{ criteria: UserQueryCriteria(id=null, blurry=null, enabled=null, createTime=null) pageable: Page request [number: 0, size 10, sort: id: DESC] }', '0:0:0:0:0:0:0:1', 92, 'admin'),
	(3, '内网IP', 'Chrome 8', '2020-04-27 09:13:25', '查询用户', NULL, 'INFO', 'com.lcyan.admin.app.service.system.controller.UserController.getUsers()', '{ criteria: UserQueryCriteria(id=null, blurry=null, enabled=null, createTime=null) pageable: Page request [number: 0, size 10, sort: id: DESC] }', '0:0:0:0:0:0:0:1', 1, 'admin'),
	(4, '内网IP', 'Chrome 8', '2020-04-27 09:13:33', '查询用户', NULL, 'INFO', 'com.lcyan.admin.app.service.system.controller.UserController.getUsers()', '{ criteria: UserQueryCriteria(id=null, blurry=null, enabled=null, createTime=null) pageable: Page request [number: 0, size 10, sort: id: DESC] }', '0:0:0:0:0:0:0:1', 2, 'admin');
/*!40000 ALTER TABLE `t_log` ENABLE KEYS */;

-- 导出  表 admin.t_menu 结构
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE IF NOT EXISTS `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cache` bit(1) DEFAULT b'0',
  `component` varchar(255) DEFAULT NULL,
  `component_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `hidden` bit(1) DEFAULT b'0',
  `i_frame` bit(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `pid` bigint(20) NOT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_menu 的数据：79 rows
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` (`id`, `cache`, `component`, `component_name`, `create_time`, `hidden`, `i_frame`, `icon`, `name`, `path`, `permission`, `pid`, `sort`, `type`) VALUES
	(1, b'0', NULL, NULL, '2018-12-18 15:11:29', b'0', b'0', 'system', '系统管理', 'system', NULL, 0, 1, 0),
	(2, b'0', 'system/user/index', 'User', '2018-12-18 15:14:44', b'0', b'0', 'peoples', '用户管理', 'user', 'user:list', 1, 2, 1),
	(3, b'0', 'system/role/index', 'Role', '2018-12-18 15:16:07', b'0', b'0', 'role', '角色管理', 'role', 'roles:list', 1, 3, 1),
	(5, b'0', 'system/menu/index', 'Menu', '2018-12-18 15:17:28', b'0', b'0', 'menu', '菜单管理', 'menu', 'menu:list', 1, 5, 1),
	(6, b'0', NULL, NULL, '2018-12-18 15:17:48', b'0', b'0', 'monitor', '系统监控', 'monitor', NULL, 0, 10, 0),
	(7, b'0', 'monitor/log/index', 'Log', '2018-12-18 15:18:26', b'0', b'0', 'log', '操作日志', 'logs', NULL, 6, 11, 1),
	(9, b'0', 'monitor/sql/index', 'Sql', '2018-12-18 15:19:34', b'0', b'0', 'sqlMonitor', 'SQL监控', 'druid', NULL, 6, 18, 1),
	(10, b'0', NULL, NULL, '2018-12-19 13:38:16', b'0', b'0', 'zujian', '组件管理', 'components', NULL, 0, 50, 0),
	(11, b'0', 'components/icons/index', 'Icons', '2018-12-19 13:38:49', b'0', b'0', 'icon', '图标库', 'icon', NULL, 10, 51, 1),
	(14, b'0', 'tools/email/index', 'Email', '2018-12-27 10:13:09', b'0', b'0', 'email', '邮件工具', 'email', NULL, 36, 35, 1),
	(15, b'0', 'components/Editor', 'Editor', '2018-12-27 11:58:25', b'0', b'0', 'fwb', '富文本', 'tinymce', NULL, 10, 52, 1),
	(16, b'0', 'tools/picture/index', 'Pictures', '2018-12-28 09:36:53', b'0', b'0', 'image', '图床管理', 'pictures', 'pictures:list', 36, 33, 1),
	(18, b'0', 'tools/storage/index', 'Storage', '2018-12-31 11:12:15', b'0', b'0', 'qiniu', '存储管理', 'storage', 'storage:list', 36, 34, 1),
	(19, b'0', 'tools/aliPay/index', 'AliPay', '2018-12-31 14:52:38', b'0', b'0', 'alipay', '支付宝工具', 'aliPay', NULL, 36, 37, 1),
	(21, b'0', '', NULL, '2019-01-04 16:22:03', b'1', b'0', 'menu', '多级菜单', 'nested', NULL, 0, 900, 0),
	(22, b'0', 'nested/menu1/index', NULL, '2019-01-04 16:23:29', b'0', b'0', 'menu', '二级菜单1', 'menu1', NULL, 21, 999, 1),
	(23, b'0', 'nested/menu2/index', NULL, '2019-01-04 16:23:57', b'0', b'0', 'menu', '二级菜单2', 'menu2', NULL, 21, 999, 1),
	(24, b'0', 'nested/menu1/menu1-1', NULL, '2019-01-04 16:24:48', b'0', b'0', 'menu', '三级菜单1', 'menu1-1', NULL, 22, 999, 1),
	(27, b'0', 'nested/menu1/menu1-2', NULL, '2019-01-07 17:27:32', b'0', b'0', 'menu', '三级菜单2', 'menu1-2', NULL, 22, 999, 1),
	(28, b'0', 'system/timing/index', 'Timing', '2019-01-07 20:34:40', b'0', b'0', 'timing', '定时任务', 'timing', 'timing:list', 36, 31, 1),
	(30, b'1', 'generator/index', 'GeneratorIndex', '2019-01-11 15:45:55', b'0', b'0', 'dev', '代码生成', 'generator', NULL, 36, 32, 1),
	(32, b'0', 'monitor/log/errorLog', 'ErrorLog', '2019-01-13 13:49:03', b'0', b'0', 'error', '异常日志', 'errorLog', NULL, 6, 12, 1),
	(33, b'0', 'components/MarkDown', 'Markdown', '2019-03-08 13:46:44', b'0', b'0', 'markdown', 'Markdown', 'markdown', NULL, 10, 53, 1),
	(34, b'0', 'components/YamlEdit', 'YamlEdit', '2019-03-08 15:49:40', b'0', b'0', 'dev', 'Yaml编辑器', 'yaml', NULL, 10, 54, 1),
	(35, b'0', 'system/dept/index', 'Dept', '2019-03-25 09:46:00', b'0', b'0', 'dept', '部门管理', 'dept', 'dept:list', 1, 6, 1),
	(36, b'0', '', NULL, '2019-03-29 10:57:35', b'0', b'0', 'sys-tools', '系统工具', 'sys-tools', NULL, 0, 30, 0),
	(37, b'0', 'system/job/index', 'Job', '2019-03-29 13:51:18', b'0', b'0', 'Steve-Jobs', '岗位管理', 'job', 'job:list', 1, 7, 1),
	(38, b'0', 'tools/swagger/index', 'Swagger', '2019-03-29 19:57:53', b'0', b'0', 'swagger', '接口文档', 'swagger2', NULL, 36, 36, 1),
	(39, b'0', 'system/dict/index', 'Dict', '2019-04-10 11:49:04', b'0', b'0', 'dictionary', '字典管理', 'dict', 'dict:list', 1, 8, 1),
	(41, b'0', 'monitor/online/index', 'OnlineUser', '2019-10-26 22:08:43', b'0', b'0', 'Steve-Jobs', '在线用户', 'online', NULL, 6, 10, 1),
	(44, b'0', '', '', '2019-10-29 10:59:46', b'0', b'0', '', '用户新增', '', 'user:add', 2, 2, 2),
	(45, b'0', '', '', '2019-10-29 11:00:08', b'0', b'0', '', '用户编辑', '', 'user:edit', 2, 3, 2),
	(46, b'0', '', '', '2019-10-29 11:00:23', b'0', b'0', '', '用户删除', '', 'user:del', 2, 4, 2),
	(48, b'0', '', '', '2019-10-29 12:45:34', b'0', b'0', '', '角色创建', '', 'roles:add', 3, 2, 2),
	(49, b'0', '', '', '2019-10-29 12:46:16', b'0', b'0', '', '角色修改', '', 'roles:edit', 3, 3, 2),
	(50, b'0', '', '', '2019-10-29 12:46:51', b'0', b'0', '', '角色删除', '', 'roles:del', 3, 4, 2),
	(52, b'0', '', '', '2019-10-29 12:55:07', b'0', b'0', '', '菜单新增', '', 'menu:add', 5, 2, 2),
	(53, b'0', '', '', '2019-10-29 12:55:40', b'0', b'0', '', '菜单编辑', '', 'menu:edit', 5, 3, 2),
	(54, b'0', '', '', '2019-10-29 12:56:00', b'0', b'0', '', '菜单删除', '', 'menu:del', 5, 4, 2),
	(56, b'0', '', '', '2019-10-29 12:57:09', b'0', b'0', '', '部门新增', '', 'dept:add', 35, 2, 2),
	(57, b'0', '', '', '2019-10-29 12:57:27', b'0', b'0', '', '部门编辑', '', 'dept:edit', 35, 3, 2),
	(58, b'0', '', '', '2019-10-29 12:57:41', b'0', b'0', '', '部门删除', '', 'dept:del', 35, 4, 2),
	(60, b'0', '', '', '2019-10-29 12:58:27', b'0', b'0', '', '岗位新增', '', 'job:add', 37, 2, 2),
	(61, b'0', '', '', '2019-10-29 12:58:45', b'0', b'0', '', '岗位编辑', '', 'job:edit', 37, 3, 2),
	(62, b'0', '', '', '2019-10-29 12:59:04', b'0', b'0', '', '岗位删除', '', 'job:del', 37, 4, 2),
	(64, b'0', '', '', '2019-10-29 13:00:17', b'0', b'0', '', '字典新增', '', 'dict:add', 39, 2, 2),
	(65, b'0', '', '', '2019-10-29 13:00:42', b'0', b'0', '', '字典编辑', '', 'dict:edit', 39, 3, 2),
	(66, b'0', '', '', '2019-10-29 13:00:59', b'0', b'0', '', '字典删除', '', 'dict:del', 39, 4, 2),
	(70, b'0', '', '', '2019-10-29 13:05:34', b'0', b'0', '', '图片上传', '', 'pictures:add', 16, 2, 2),
	(71, b'0', '', '', '2019-10-29 13:05:52', b'0', b'0', '', '图片删除', '', 'pictures:del', 16, 3, 2),
	(73, b'0', '', '', '2019-10-29 13:07:28', b'0', b'0', '', '任务新增', '', 'timing:add', 28, 2, 2),
	(74, b'0', '', '', '2019-10-29 13:07:41', b'0', b'0', '', '任务编辑', '', 'timing:edit', 28, 3, 2),
	(75, b'0', '', '', '2019-10-29 13:07:54', b'0', b'0', '', '任务删除', '', 'timing:del', 28, 4, 2),
	(77, b'0', '', '', '2019-10-29 13:09:09', b'0', b'0', '', '上传文件', '', 'storage:add', 18, 2, 2),
	(78, b'0', '', '', '2019-10-29 13:09:22', b'0', b'0', '', '文件编辑', '', 'storage:edit', 18, 3, 2),
	(79, b'0', '', '', '2019-10-29 13:09:34', b'0', b'0', '', '文件删除', '', 'storage:del', 18, 4, 2),
	(80, b'0', 'monitor/server/index', 'ServerMonitor', '2019-11-07 13:06:39', b'0', b'0', 'codeConsole', '服务监控', 'server', 'server:list', 6, 14, 1),
	(82, b'1', 'generator/config', 'GeneratorConfig', '2019-11-17 20:08:56', b'1', b'0', 'dev', '生成配置', 'generator/config/:tableName', '', 36, 33, 1),
	(83, b'1', 'components/Echarts', 'Echarts', '2019-11-21 09:04:32', b'0', b'0', 'chart', '图表库', 'echarts', '', 10, 50, 1),
	(90, b'0', '', 'Mnt', '2019-11-09 10:31:08', b'0', b'0', 'mnt', '运维管理', 'mnt', NULL, 0, 20, 1),
	(92, b'0', 'mnt/server/index', 'ServerDeploy', '2019-11-10 10:29:25', b'0', b'0', 'server', '服务器', 'mnt/serverDeploy', 'serverDeploy:list', 90, 22, 1),
	(93, b'0', 'mnt/app/index', 'App', '2019-11-10 11:05:16', b'0', b'0', 'app', '应用管理', 'mnt/app', 'app:list', 90, 23, 1),
	(94, b'0', 'mnt/deploy/index', 'Deploy', '2019-11-10 15:56:55', b'0', b'0', 'deploy', '部署管理', 'mnt/deploy', 'deploy:list', 90, 24, 1),
	(97, b'0', 'mnt/deployHistory/index', 'DeployHistory', '2019-11-10 16:49:44', b'0', b'0', 'backup', '部署备份', 'mnt/deployHistory', 'deployHistory:list', 90, 25, 1),
	(98, b'0', 'mnt/database/index', 'Database', '2019-11-10 20:40:04', b'0', b'0', 'database', '数据库管理', 'mnt/database', 'database:list', 90, 26, 1),
	(102, b'0', '', '', '2019-11-17 09:32:48', b'0', b'0', '', '删除', '', 'deployHistory:del', 97, 999, 2),
	(103, b'0', '', '', '2019-11-17 11:08:33', b'0', b'0', '', '服务器新增', '', 'serverDeploy:add', 92, 999, 2),
	(104, b'0', '', '', '2019-11-17 11:08:57', b'0', b'0', '', '服务器编辑', '', 'serverDeploy:edit', 92, 999, 2),
	(105, b'0', '', '', '2019-11-17 11:09:15', b'0', b'0', '', '服务器删除', '', 'serverDeploy:del', 92, 999, 2),
	(106, b'0', '', '', '2019-11-17 11:10:03', b'0', b'0', '', '应用新增', '', 'app:add', 93, 999, 2),
	(107, b'0', '', '', '2019-11-17 11:10:28', b'0', b'0', '', '应用编辑', '', 'app:edit', 93, 999, 2),
	(108, b'0', '', '', '2019-11-17 11:10:55', b'0', b'0', '', '应用删除', '', 'app:del', 93, 999, 2),
	(109, b'0', '', '', '2019-11-17 11:11:22', b'0', b'0', '', '部署新增', '', 'deploy:add', 94, 999, 2),
	(110, b'0', '', '', '2019-11-17 11:11:41', b'0', b'0', '', '部署编辑', '', 'deploy:edit', 94, 999, 2),
	(111, b'0', '', '', '2019-11-17 11:12:01', b'0', b'0', '', '部署删除', '', 'deploy:del', 94, 999, 2),
	(112, b'0', '', '', '2019-11-17 11:12:43', b'0', b'0', '', '数据库新增', '', 'database:add', 98, 999, 2),
	(113, b'0', '', '', '2019-11-17 11:12:58', b'0', b'0', '', '数据库编辑', '', 'database:edit', 98, 999, 2),
	(114, b'0', '', '', '2019-11-17 11:13:14', b'0', b'0', '', '数据库删除', '', 'database:del', 98, 999, 2),
	(116, b'1', 'generator/preview', 'Preview', '2019-11-26 14:54:36', b'1', b'0', 'java', '生成预览', 'generator/preview/:tableName', NULL, 36, 999, 1);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;

-- 导出  表 admin.t_role 结构
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `data_scope` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_role 的数据：2 rows
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `create_time`, `data_scope`, `level`, `name`, `permission`, `remark`) VALUES
	(1, '2018-11-23 11:04:37', NULL, 1, '超级管理员', 'admin', '-'),
	(2, '2018-11-23 13:09:06', NULL, 2, '普通用户', 'common', '-');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 admin.t_roles_menus 结构
DROP TABLE IF EXISTS `t_roles_menus`;
CREATE TABLE IF NOT EXISTS `t_roles_menus` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FKe07wgr0jfvqtny2u0pbdpvfcv` (`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_roles_menus 的数据：0 rows
/*!40000 ALTER TABLE `t_roles_menus` DISABLE KEYS */;
INSERT INTO `t_roles_menus` (`role_id`, `menu_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 9),
	(1, 10),
	(1, 11),
	(1, 14),
	(1, 15),
	(1, 16),
	(1, 18),
	(1, 19),
	(1, 21),
	(1, 22),
	(1, 23),
	(1, 24),
	(1, 27),
	(1, 28),
	(1, 30),
	(1, 32),
	(1, 33),
	(1, 34),
	(1, 35),
	(1, 36),
	(1, 37),
	(1, 38),
	(1, 39),
	(1, 41),
	(1, 44),
	(1, 45),
	(1, 46),
	(1, 48),
	(1, 49),
	(1, 50),
	(1, 52),
	(1, 53),
	(1, 54),
	(1, 56),
	(1, 57),
	(1, 58),
	(1, 60),
	(1, 61),
	(1, 62),
	(1, 64),
	(1, 65),
	(1, 66),
	(1, 73),
	(1, 74),
	(1, 75),
	(1, 77),
	(1, 78),
	(1, 79),
	(1, 80),
	(1, 82),
	(1, 83),
	(1, 90),
	(1, 92),
	(1, 93),
	(1, 94),
	(1, 97),
	(1, 98),
	(1, 116),
	(2, 1),
	(2, 2),
	(2, 3),
	(2, 5),
	(2, 6),
	(2, 9),
	(2, 10),
	(2, 11),
	(2, 14),
	(2, 15),
	(2, 18),
	(2, 19),
	(2, 21),
	(2, 23),
	(2, 24),
	(2, 27),
	(2, 28),
	(2, 30),
	(2, 33),
	(2, 34),
	(2, 35),
	(2, 36),
	(2, 37),
	(2, 38),
	(2, 39),
	(2, 44),
	(2, 48),
	(2, 49),
	(2, 50),
	(2, 77),
	(2, 78),
	(2, 79);
/*!40000 ALTER TABLE `t_roles_menus` ENABLE KEYS */;

-- 导出  表 admin.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `last_password_reset_time` datetime DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `avatar_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5r510tv6chq2q6bfrwy8w826g` (`avatar_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_user 的数据：0 rows
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `create_time`, `email`, `enabled`, `last_password_reset_time`, `nick_name`, `password`, `phone`, `sex`, `username`, `avatar_id`) VALUES
	(1, '2018-08-23 09:11:56', 'zhengjie@tom.com', b'1', '2019-05-18 17:34:21', '管理员', '$2a$10$fP.426qKaTmix50Oln8L.uav55gELhAd0Eg66Av4oG86u8km7D/Ky', '18888888888', '男', 'admin', NULL),
	(3, '2018-12-27 20:05:26', 'test@eladmin.net', b'1', '2019-04-01 09:15:24', '测试', '$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF.', '17777777777', '男', 'test', NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 admin.t_users_roles 结构
DROP TABLE IF EXISTS `t_users_roles`;
CREATE TABLE IF NOT EXISTS `t_users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK20cv6kext73rv9jnqfkw9uhqr` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_users_roles 的数据：0 rows
/*!40000 ALTER TABLE `t_users_roles` DISABLE KEYS */;
INSERT INTO `t_users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(3, 2);
/*!40000 ALTER TABLE `t_users_roles` ENABLE KEYS */;

-- 导出  表 admin.t_user_avatar 结构
DROP TABLE IF EXISTS `t_user_avatar`;
CREATE TABLE IF NOT EXISTS `t_user_avatar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_user_avatar 的数据：0 rows
/*!40000 ALTER TABLE `t_user_avatar` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_avatar` ENABLE KEYS */;

-- 导出  表 admin.t_verification_code 结构
DROP TABLE IF EXISTS `t_verification_code`;
CREATE TABLE IF NOT EXISTS `t_verification_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `scenes` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  admin.t_verification_code 的数据：0 rows
/*!40000 ALTER TABLE `t_verification_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_verification_code` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
