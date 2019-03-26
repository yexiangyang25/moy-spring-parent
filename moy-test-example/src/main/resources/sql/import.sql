DROP database if EXISTS `spring-boot`;
CREATE database `spring-boot` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;;
USE `spring-boot`;
-- 用户
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50)  COMMENT '名称',
  `code` varchar(32) UNIQUE COMMENT '编码' ,
  `telephone` varchar(20)  COMMENT '手机号码',
  `status` int (1)  COMMENT '有效状态',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 密码
DROP TABLE IF EXISTS `t_password`;
CREATE TABLE `t_password` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32)  COMMENT '编码',
  `user_code` varchar(32)  COMMENT '用户编码',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 角色
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) UNIQUE COMMENT '编码',
  `name` varchar(50)  COMMENT '名称',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 权限关系
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) UNIQUE  COMMENT '编码',
  `name` varchar(50)  COMMENT '名称',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户角色关系
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(32)  COMMENT '用户编码',
  `role_code` varchar(32)  COMMENT '角色编码',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 角色权限关系
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(32)  COMMENT '角色编码',
  `permission_code` varchar(32)  COMMENT '权限编码',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 博客
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32)  COMMENT '编码',
  `title` varchar(50) UNIQUE COMMENT '文章题目' ,
  `content` nvarchar(2500)  COMMENT '文章内容',
  `content_short` varchar(50)  COMMENT '文章摘要',
  `image_uri` varchar(50)  COMMENT '文章内容',
  `display_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发布时间',
  `comment_disabled` varchar(20)  COMMENT '是否评论',
  `importance` int(1)  COMMENT '评价',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 博客标签
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32)  COMMENT '编码',
  `name` varchar(50) UNIQUE COMMENT '名称' ,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  `founder` varchar(50) NOT NULL COMMENT '创建人',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `operate_time` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '操作时间',
  `version` bigint(20) COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 博客标签关系
DROP TABLE IF EXISTS `t_article_tag`;
CREATE TABLE `t_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_code` varchar(32)  COMMENT '标签编码',
  `article_code` varchar(32)  COMMENT '文章编码' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;