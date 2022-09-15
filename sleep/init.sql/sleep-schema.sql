create database if not exists sleep_test;

drop user 'root'@'%';

create user 'root'@'%' identified by 'password';

grant all on sleep_test.* to 'root'@'%'

use sleep_test;

create table if not exists sleep (
    id int not null primary key auto_increment,
    start timestamp,
    end timestamp,
    feel VARCHAR(100)
);