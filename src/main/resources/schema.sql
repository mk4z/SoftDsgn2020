drop table if exists authn_data cascade;

create table authn_data
(
    user_id       varchar(8) primary key,
    user_password varchar(32) NOT NULL,
    user_name     varchar(8)  NOT NULL
);

insert into authn_data
values ('b1960010', 'qwerty', '長沼 太郎');

insert into authn_data
values ('b2182360', 'asdfgh', '三浦 一斗');
