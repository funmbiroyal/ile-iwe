create database ile_iwedb;

create user 'ile-iwe_user'@'localhost'identified by 'Semicolon';
grant all privileges on ile_iwedb.* to 'ile-iwe_user'@'localhost';

flush privileges ;