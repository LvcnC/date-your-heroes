create database datingapp;
use datingapp;
drop table users;

create table users(
	id int primary key auto_increment,
	name varchar(40),
    surname varchar(40),
    username varchar(40),
    password varchar(40),
    dob date,
    sex tinyint
);

INSERT INTO users 
(name,surname,username,password,dob,sex)
values
("ciccio","verdi", "cic0", "12345678","1888-10-05",0);

UPDATE users
SET name = ?,
	surname = ?,
    username = ?,
    dob = ?,
    sex = ?
WHERE id = ?;