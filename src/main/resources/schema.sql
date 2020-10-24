DROP TABLE IF EXISTS books;
--DROP TABLE IF EXISTS users;
create table if not exists books (
id bigint not null auto_increment PRIMARY KEY,
title varchar(50) not null,
isbn char(13) not null,
publication_date date not null,
number_of_pages smallint(4) not null,
genre varchar(20) not null,
author varchar(30) not null,
publishing_house varchar(50) not null
);