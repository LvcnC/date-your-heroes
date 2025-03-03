create database datingapp;
drop database datingapp;
use datingapp;
drop table users;

create table users(
	user_id int primary key auto_increment,
	name varchar(40),
    surname varchar(40),
    username varchar(40) unique NOT NULL,
    password varchar(40),
    dob date,
    sex tinyint,
    sexualOrientation varchar(40)
);

INSERT INTO users 
(name,surname,username,password,dob,sex)
values
("ciccio","verdi", "cic0", "12345678","1888-10-05",0);

update users
set sexualOrientation = "straight"
where user_id = 1;

INSERT INTO users 
(name,surname,username,password,dob,sex,sexualOrientation)
values
("leunis","verlinde", "leunis", "leunisleunis","1993-11-25",0, "straight");

create table characters(
	character_id int primary key auto_increment,
    name varchar(40),
    surname varchar(40),
    username varchar(40) unique NOT NULL,
    dob date,
    sex tinyint,
    historical_period varchar(40)
);

use datingapp;

INSERT INTO characters 
(name,surname,username,dob,sex,historical_period)
values
("joseph","stalin", "stalin", "1893-03-03",0,"contemporary era");

UPDATE users
SET name = ?,
	surname = ?,
    username = ?,
    dob = ?,
    sex = ?
WHERE id = ?;

create table interests(
	interest_id int primary key auto_increment,
    name varchar(40)
);

insert into interests (name)
values
("art");

-- a ciccio piace la guerra 
insert into user_interest
values
(1,2);

drop table user_interest;
create table user_interest(
	user_id int,
    interest_id int,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (interest_id) REFERENCES interests(interest_id)
);

create table character_interest(
	character_id int,
    interest_id int,
	FOREIGN KEY (character_id) REFERENCES characters(character_id),
    FOREIGN KEY (interest_id) REFERENCES interests(interest_id)
);

insert into character_interest values(2,1);

select * from character_interest;

SELECT 	users.name as 'user',
		interests.name as 'interest'
FROM    interests INNER JOIN user_interest
ON		interests.interest_id = user_interest.interest_id 
INNER JOIN users
ON			users.user_id = user_interest.user_id
WHERE 		users.name = ?;

SELECT 	interests.interest_id as 'id',
		interests.name as 'name'
FROM    interests INNER JOIN user_interest
ON		interests.interest_id = user_interest.interest_id 
INNER JOIN users
ON			users.user_id = user_interest.user_id
WHERE 		users.name = "ciccio";

SELECT 	characters.name as 'character',
		interests.name as 'interest'
FROM    interests INNER JOIN character_interest
ON		interests.interest_id = character_interest.interest_id
INNER JOIN characters
ON			characters.character_id  = character_interest.character_id
WHERE 		characters.name = "joseph";

-- check if one user and one character match in terms of interests
SELECT characters.name as 'character',
		users.name as 'user',
        interests.name as 'shared interest'
FROM	character_interest INNER JOIN characters
ON		character_interest.character_id = characters.character_id
INNER JOIN	user_interest
ON		character_interest.interest_id = user_interest.interest_id
INNER JOIN 	users
ON			user_interest.user_id = users.user_id
INNER JOIN	interests
ON			user_interest.interest_id = interests.interest_id
WHERE		users.name = "leunis";

-- CONTROLLA se l'utente e il personaggio hanno lo stesso interesse 
	-- user_interest.interest_id = character_interest.interest_id
SELECT users.name as 'user',
		characters.name as 'character',
        interests.name as 'shared_interest'
FROM	user_interest INNER JOIN character_interest
ON		user_interest.interest_id = character_interest.interest_id
INNER JOIN	users
ON		users.user_id = user_interest.user_id
INNER JOIN	characters
ON		characters.character_id = character_interest.character_id
INNER JOIN	interests
ON		interests.interest_id = user_interest.interest_id;
-- tutto il resto serve per la disposizione, in più characters, users e interests vanno combaciati per mostrarli

SELECT users.name as 'user',
        interests.name as 'shared_interest',
        COUNT(*) AS count_interest 
FROM	user_interest INNER JOIN character_interest
ON		user_interest.interest_id = character_interest.interest_id
INNER JOIN	users
ON		users.user_id = user_interest.user_id
INNER JOIN	characters
ON		characters.character_id = character_interest.character_id
INNER JOIN	interests
ON		interests.interest_id = user_interest.interest_id
WHERE	users.user_id = 1
GROUP BY	users.name
ORDER BY	count_interest DESC;

SELECT 
    users.name AS 'user',
    characters.name AS 'character',
    COUNT(character_interest.character_id) AS count_interest  -- how often the name appears...
FROM 
    user_interest
INNER JOIN character_interest
    ON user_interest.interest_id = character_interest.interest_id
INNER JOIN users
    ON users.user_id = user_interest.user_id
INNER JOIN characters
    ON characters.character_id = character_interest.character_id
INNER JOIN interests
    ON interests.interest_id = user_interest.interest_id
WHERE 
    users.user_id = 1  -- Filter by the specific user (user_id = 1)
GROUP BY 
    users.name, characters.name  -- Group by user and character
ORDER BY 
    count_interest DESC;  -- Order by the count of shared interests in descending order


insert into interests
(name)
values
("ww2");

insert into character_interest
values
(1,3);