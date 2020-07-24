
SET MODE PostgreSQL;
/*CREATE DATABASE usline-_clinic;
\c usline-clinic;*/
CREATE TABLE IF NOT EXISTS login (id int PRIMARY KEY auto_increment, username varchar, password varchar, docid integer, patid integer);
CREATE TABLE IF NOT EXISTS patient (id int PRIMARY KEY auto_increment, firstname varchar, lastname varchar, email varchar, password varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE IF NOT EXISTS doctor (id int PRIMARY KEY auto_increment, firstname varchar, lastname varchar, email varchar, password varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE IF NOT EXISTS appointment (id int PRIMARY KEY auto_increment, day timestamp,starttime timestamp,endtime timestamp, docid int, patid int);


/*CREATE DATABASE usline_clinic_test WITH TEMPLATE usline_clinic;*/
