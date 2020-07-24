

CREATE DATABASE usline_clinic;
\c usline_clinic;
CREATE TABLE IF NOT EXISTS login (id SERIAL PRIMARY KEY, userName varchar, password varchar, docId integer, patId integer);
CREATE TABLE IF NOT EXISTS patient (id SERIAL PRIMARY KEY, firstName varchar, lastName varchar, email varchar, password varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE IF NOT EXISTS doctor (id SERIAL PRIMARY KEY, firstName varchar, lastName varchar, email varchar, password varchar, gender varchar, phone varchar, role varchar);
CREATE TABLE IF NOT EXISTS appointment (id SERIAL PRIMARY KEY, day timestamp,startTime timestamp,endTime timestamp, docId int, patId int);
CREATE DATABASE usline_clinic_test WITH TEMPLATE usline_clinic;
