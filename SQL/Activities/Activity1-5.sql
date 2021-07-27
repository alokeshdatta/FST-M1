REM   Script: Activity1-5
REM   FST

desc salesmen


CREATE TABLE salesmen ( 
    salesmen_id int, 
    salesmen_name varchar2(32), 
    salesmen_city varchar2(32), 
    commission int 
);

INSERT INTO salesmen VALUES(5001, 'James Hoog', 'New York', 15);

INSERT ALL 
    INTO salesmen VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesmen VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesmen VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesmen VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesmen VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

commit


Select * from salesmen;

select salesmen_id, salesmen_city from salesmen;

select * from salesmen where salesmen_city='Paris';

select salesmen_id, commission from salesmen where salesmen_name='Paul Adam';

alter table salesmen add Grade int;

update salesmen set Grade=100;

select * from salesmen;

update salesmen set Grade=200 where salesmen_city='Rome';

commit


select * from salesmen;

update salesmen set Grade=300 where salesmen_name='James Hogg';

update salesmen set salesmen_name='Pierre' where salesmen_name='McLyon';

select * from salesmen;

update salesmen set Grade=300 where salesmen_name='James Hoog';

commit


select * from salesmen;

