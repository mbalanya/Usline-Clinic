CREATE DATABASE usline_clinic;
CREATE TABLE userlogin(id serial PRIMARY KEY, username varchar, password varchar, docid integer, patid integer );
CREATE TABLE patient(id serial PRIMARY KEY, email varchar,firstname varchar, lastname varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE doctor(id serial PRIMARY KEY, email varchar,firstname varchar, lastname varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE appointment(id serial PRIMARY KEY, day timestamp, starttime timestamp, endtime timestamp docid integer, patid integer);

CREATE DATABASE usline_clinic_test WITH TEMPLATE usline_clinic;
