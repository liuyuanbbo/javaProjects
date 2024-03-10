create table ebook
(
    id           bigint       not null primary key auto_increment comment '主键自增Id',
    name         varchar(60)  not null comment '书名',
    category1_id int          not null comment '分类1',
    category2_id int          not null comment '分类2',
    description  varchar(200) comment '描述',
    cover        varchar(200) not null comment '封面',
    doc_count    int          not null comment '文档数',
    view_count   int          not null comment '阅读数',
    vote_count   int          not null comment '点赞数'
);

