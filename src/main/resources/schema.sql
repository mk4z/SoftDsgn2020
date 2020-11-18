drop table if exists authn_data cascade;
drop table if exists todo_item cascade;

create table authn_data
(
    user_id       varchar(8) primary key,
    user_password varchar(32) NOT NULL,
    user_name     varchar(8)  NOT NULL
);

create table todo_item
(
  user_id varchar(8) not null,
  subject varchar(16) not null,
  body varchar(200) not null
);

insert into authn_data
values ('b1960010', 'qwerty', '長沼 太郎');

insert into authn_data
values ('b2182360', 'asdfgh', '三浦 一斗');

insert into todo_item
values ('b2182360', '11/10の買い物', '紅鮭、お汁粉、パン');
