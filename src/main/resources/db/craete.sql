CREATE DATABASE usline-_clinic;
\c usline-clinic;
CREATE TABLE userlogin(id serial PRIMARY KEY, username varchar, password varchar, docid integer, patid integer);
CREATE TABLE patient(id serial PRIMARY KEY, firstname varchar, lastname varchar, email varchar, password varchar, gendar varchar, phone varchar,role varchar);
CREATE TABLE doctor(id serial PRIMARY KEY, firstname varchar, lastname varchar, email varchar, password varchar, gendar varchar, phone varchar,role varchar);
CREATE TABLE appointment(id serial PRIMARY KEY, day timestamp,starttime timestamp,endtime timestamp, docid int, patid int);

CREATE DATABASE usline_clinic_test WITH TEMPLATE usline_clinic;