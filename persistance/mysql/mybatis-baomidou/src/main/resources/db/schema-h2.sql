DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    sex INT(11)  NULL DEFAULT NULL COMMENT '性别',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    version int(11) NOT NULL DEFAULT '1' COMMENT 'cas版本号',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id),
    UNIQUE (name)
);