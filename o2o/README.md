# o2o项目
use o2o;
create table tb_area(
    area_id int(2) NOT NULL auto_increment PRIMARY KEY COMMENT '主键',
    area_name varchar(200) not null COMMENT '区域名称',
    priority int(2) not null default '0' COMMENT '权重',
    create_time datetime default null COMMENT '创建时间',
    last_edit_time datetime default now() COMMENT '更新时间',
    unique key UK_AREA(area_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset =utf8 COMMENT '地区表';


use o2o;
create table tb_person_info(
  user_id int(10) not null auto_increment primary key comment '主键',
  name varchar(32) default '' comment '姓名',
  profile_img varchar(1024) default '' comment '头像，对接到微信平台',
  email varchar(1024) default '' comment '电子邮箱',
  gender varchar(2) default '' comment '性别',
  enable_status int(2) not null default 0 comment '用户状态：0.禁止登陆；1表示可以使用本商城；',
  user_type int(2) not null default 1 comment '1:顾客,2:商家,3:超级管理员',
  create_time datetime default null comment '创建时间',
  last_edit_time datetime default null comment '最后一次操作的时间'
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '客户信息表';


use o2o;
create table tb_wechat_auth(
    wechat_auth_id int(10) not null auto_increment primary key comment '主键',
    user_id int(10) not null comment '用户ID',
    open_id varchar(1024) not null comment 'openID',
    create_time datetime default null comment '创建时间',
    # 添加外键约束
    constraint fk_wechatauth_profile foreign key (user_id) references tb_person_info(user_id)
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '微信对象表';

create table tb_local_auth(
    local_auth_id int(10) not null auto_increment primary key comment '主键',
    user_id int(10) not null comment '用户ID',
    user_name varchar(128) not null comment '用户名',
    password varchar(128) not null comment '密码',
    create_time datetime default null comment '创建时间',
    # 添加唯一约束
    unique key uk_local_profile(user_name),
    # 添加外键约束
    constraint fk_localauth_profile foreign key (user_id) references tb_person_info(user_id)
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '本地对象表';

#为 open_id添加唯一索引
alter table tb_wechat_auth add unique index(open_id);

use o2o;
create table tb_head_line(
    lineId int(100) not null auto_increment primary key comment '主键',
    line_name varchar(1000) not null default '' comment '头条名称',
    line_link varchar(2000) not null comment '头条链接',
    line_img  varchar(2000) not null  comment '头条图片',
    priority int(2) not null default 0 comment '权重',
    enable_status int(2) not null default '0' comment '头条状态',
    create_time datetime default  null comment '创建时间',
    last_edit_time datetime default null comment '更新时间'
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '头条信息表';

create table tb_shop_category(
    shop_category_id int(11) not null auto_increment primary key comment '商品类型ID 主键',
    shop_category_name varchar(100) not null default '' comment '商品名称',
    shop_category_desc varchar(1000) not null default '' comment '商品描述',
    shop_category_img  varchar(2000) not null  default '' comment '商品图片',
    priority int(2) not null default '0' comment '权重',
    create_time datetime  default null comment '创建时间',
    last_edit_time datetime  default null comment '更新时间',
    parent_id int(11) default null comment '父ID',
    constraint fk_shop_category_self foreign key (parent_id) references tb_shop_category(shop_category_id)
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '商品表';

use o2o;
create table tb_shop(
    shop_id int(10) not null auto_increment primary key comment '店铺id 主键',
    owner_id int(10) not null  comment '店铺创建人',
    area_id int(5) default null  comment '区域id',
    shop_category_id int(11) default null comment '商品类别id',
    shop_name varchar(256) not null default '' comment '店铺名称',
    shop_desc varchar(1024) not null default '' comment '店铺描述',
    shop_addr varchar(200) not null default '' comment '店铺地址',
    shop_img  varchar(1024) not null  default '' comment '店铺图片',
    priority int(3) not null default 0 comment '权重',
    create_time datetime  default null comment '创建时间',
    last_edit_time datetime  default null comment '更新时间',
    enable_status int(2) default 0 not null comment '店铺状态 -1 不可用 0 审核中 1 可用',
    advice varchar(255) default null comment '超级管理员对商铺的通告',
    constraint fk_shop_area foreign key (area_id) references tb_area(area_id),
    constraint fk_shop_profile foreign key (owner_id) references tb_person_info(user_id),
    constraint fk_shop_shopcate foreign key (shop_category_id) references tb_shop_category(shop_category_id)
)ENGINE = InnoDB auto_increment = 1 default charset = utf8 comment '店铺表';

