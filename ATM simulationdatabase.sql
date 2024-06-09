show databases;
use bankmanagementsystem;
show tables;

create table signup(formnumber varchar(20),name varchar(20),father_name varchar(20),dob varchar(20),gender varchar(20),email varchar(40),marital_status varchar(20),address varchar(40),city varchar(40),state varchar(40),pincode varchar(20));
show tables;
select * from signup;
create table signuptwo (formnumber varchar(20),religion varchar(20),category varchar(20),income varchar(20),qualification varchar(20),occupation varchar(40),senior_citizen varchar(20),pan varchar(40),aadhar varchar(40),existing_account varchar(40));
select * from signuptwo;

create table signupthree (formnumber varchar(20),accounType varchar(40),cardnumber varchar(120),pin varchar(10),facility varchar(150));
create table login(formnumber varchar(20), cardnumber varchar(25), pinnumber varchar(10));
select * from signupthree;
drop table signupthree;
create table signupthree (formnumber varchar(20),accounType varchar(40),cardnumber varchar(140),pin varchar(10),facility varchar(150));
select * from signupthree;

select * from login;
create table bank(pin varchar(10),date varchar(50), type varchar(20), amount varchar(20));
select * from login;
select * from login;
INSERT INTO login (cardnumber, pinnumber) VALUES ('1234567890123456', '1234');


create database bankmanagementsystem;


create table signup(formnumber varchar(20), name varchar(20), fname varchar(20), dob varchar(20), gender varchar(20),email varchar(30), marital varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));
create table signuptwo(formnumber varchar(20), sreligion varchar(20), scategory varchar(20), sincome varchar(20), squalification varchar(20), soccupation varchar(20), seniorcitizen varchar(20), span varchar(20), sexisitingaccount varchar(20), saadhar varchar(20));
create table signupthree(formnumber varchar(20), accountType varchar(40), cardnumber varchar(25), pinnumber varchar(10), facility varchar(100));
create table login(formnumber varchar(20), cardnumber varchar(25), pinnumber varchar(10));
create table bank(pinnumber varchar(10), date varchar(50), type varchar(20), amount varchar(20));
INSERT INTO login (cardnumber, pinnumber) VALUES ('6044420024116068', '2233');
select * from signup;
select * from signuptwo;
select * from signupthree;
select * from login;
select * from bank;
SELECT signup.formnumber, signup.name, signup.fname, signup.dob, signup.gender, signup.email, signup.marital, signup.address, signup.city, signup.pincode, signup.state,
       signuptwo.sreligion, signuptwo.scategory, signuptwo.sincome, signuptwo.squalification, signuptwo.soccupation, signuptwo.seniorcitizen, signuptwo.span, signuptwo.sexisitingaccount, signuptwo.saadhar,
       signupthree.accountType, signupthree.facility,
       login.cardnumber, login.pinnumber,
       bank.date, bank.type, bank.amount
FROM signup
JOIN signuptwo ON signup.formnumber = signuptwo.formnumber
JOIN signupthree ON signup.formnumber = signupthree.formnumber
JOIN login ON signup.formnumber = login.formnumber
JOIN bank ON login.pinnumber = bank.pinnumber;


drop table bank;
create table bank(pinnumber varchar(10), date varchar(50), type varchar(20), amount varchar(20));
ALTER TABLE bank ADD COLUMN balance DECIMAL(10, 2) DEFAULT 0;
ALTER TABLE bank DROP COLUMN balance;

select * from signup;
SELECT signup.*, login.cardnumber, login.pinnumber
FROM signup
JOIN login ON signup.formnumber = login.formnumber;


select * from login , signup , signuptwo , signupthree , bank;


drop database bankmanagementsystem;

show databases;


create database bankmanagementsystem;

use bankmanagementsystem;


create table signup(formnumber varchar(20), name varchar(20), fname varchar(20), dob varchar(20), gender varchar(20),email varchar(30), marital varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));
create table signuptwo(formnumber varchar(20), sreligion varchar(20), scategory varchar(20), sincome varchar(20), squalification varchar(20), soccupation varchar(20), seniorcitizen varchar(20), span varchar(20), sexisitingaccount varchar(20), saadhar varchar(20));
create table signupthree(formnumber varchar(20), accountType varchar(40), cardnumber varchar(25), pinnumber varchar(10), facility varchar(100));
create table login(formnumber varchar(20), cardnumber varchar(25), pinnumber varchar(10));
create table bank(pinnumber varchar(10), date varchar(50), type varchar(20), amount varchar(20));
INSERT INTO login (cardnumber, pinnumber) VALUES ('6044420024116068', '2233');
select * from signup;
select * from signuptwo;
select * from signupthree;
select * from login;
select * from bank;


    
    
   SELECT 
    l.*, 
    s.name, s.fname, s.dob, s.gender, s.email, s.marital, s.address, s.city, s.pincode, s.state,
    st.sreligion, st.scategory, st.sincome, st.squalification, st.soccupation, st.seniorcitizen, st.span, st.sexisitingaccount, st.saadhar,
    sth.accountType, sth.facility,
    b.*
FROM 
    login l
JOIN 
    signup s ON l.formnumber = s.formnumber
JOIN 
    signuptwo st ON s.formnumber = st.formnumber
JOIN 
    signupthree sth ON s.formnumber = sth.formnumber
JOIN 
    bank b ON l.pinnumber = b.pinnumber;


