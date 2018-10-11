-- To use native connection
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Abhisana@1993';

-- For updates
SET SQL_SAFE_UPDATES = 0;

DROP DATABASE adaptive_web;
CREATE DATABASE adaptive_web;

-- Create user table
DROP TABLE IF EXISTS adaptive_web.users ;
CREATE TABLE adaptive_web.users 
                 ( 
                              user_id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                              firstname VARCHAR(25) NOT NULL, 
                              lastname  VARCHAR(25) NOT NULL,
                              username  VARCHAR(25) NOT NULL UNIQUE, 
                              password  VARCHAR(50) NOT NULL
                 ) ENGINE=INNODB;
                 
insert into adaptive_web.users(firstname,lastname,username,password) values("aaa","aaa","aaa","123");
insert into adaptive_web.users(firstname,lastname,username,password) values("bbb","bbb","bbb","123");
insert into adaptive_web.users(firstname,lastname,username,password) values("ccc","ccc","ccc","123");

DROP TABLE IF EXISTS adaptive_web.activities;
CREATE TABLE adaptive_web.activities 
                 ( 
                              username  VARCHAR(25) NOT NULL, 
                              activity VARCHAR(25) NOT NULL,
                              date_time VARCHAR(25) NOT NULL
                 ) ENGINE=INNODB;






