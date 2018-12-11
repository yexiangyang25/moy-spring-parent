DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT '' COMMENT '用户名',
  `code` varchar(50) DEFAULT '' COMMENT '编码',
  `telephone` varchar(20) DEFAULT '' COMMENT '手机号码',
  `status` bit(1) DEFAULT 0 COMMENT '有效状态',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL COMMENT '修改时间',
  `operator` varchar(50) DEFAULT '' COMMENT '操作人',
  `operate_time` timestamp NOT NULL COMMENT '操作时间',
  `version` bigint(20) DEFAULT 1 COMMENT '版本号',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_password`;
CREATE TABLE `t_password` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) DEFAULT '' COMMENT '编码',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL COMMENT '修改时间',
  `operator` varchar(50) DEFAULT '' COMMENT '操作人',
  `operate_time` timestamp NOT NULL COMMENT '操作时间',
  `user_code` varchar(50) DEFAULT '' COMMENT '用户编码',
  PRIMARY KEY (`id`)
);