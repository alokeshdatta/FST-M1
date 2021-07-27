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

commit;

Select * from salesmen;

select salesmen_id, salesmen_city from salesmen;

select * from salesmen where salesmen_city='Paris';

select salesmen_id, commission from salesmen where salesmen_name='Paul Adam';

alter table salesmen add Grade int;

update salesmen set Grade=100;

select * from salesmen;

update salesmen set Grade=200 where salesmen_city='Rome';

commit;

select * from salesmen;

update salesmen set Grade=300 where salesmen_name='James Hogg';

update salesmen set salesmen_name='Pierre' where salesmen_name='McLyon';

select * from salesmen;

update salesmen set Grade=300 where salesmen_name='James Hoog';

commit;

select * from salesmen;

desc orders


create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

desc orders


INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

commit;

select distinct salesman_id from orders;

select order_no, order_date from orders order by order_date;

select order_no, purchase_amount from orders order by purchase_amount desc;

select * from orders where purchase_amount less than 500;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select sum(purchase_amount) from orders;

select sum(purchase_amount) as 'Total Sum' from orders;

select sum(purchase_amount) as "Total sum" from orders;

select avg(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select count(salesman_id) from orders;

select count(distinct salesman_id) from orders;

select customer_id, max(purchase_amount) as "Maximum Amt" from orders group by purchase_amount;

select customer_id, max(purchase_amount) as "Maximum Amt" from orders group by customer_id;

select * from orders;

select salesman_id, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Oct-2012' group by salesman_id;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Oct-2012' group by salesman_id;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Oct-2012' group by salesman_id, order_date;

select customer_id, max(purchase_amount) as "Maximum Amt" from orders group by customer_id;

select * from orders;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Oct-12' group by salesman_id, order_date;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ="17-Oct-12" group by salesman_id, order_date;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ="17-Aug-12" group by salesman_id, order_date;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Aug-12' group by salesman_id, order_date;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Aug-12' group by salesman_id;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Aug-12' group by order_date;

select salesman_id, order_date, max(purchase_amount) as "Highest Amt" from orders where order_date ='17-Aug-12' group by order_date, salesman_id;

select customer_id, order_date, max(purchase_amount) as "highest Amount" from orders 
group by customer_id, order_date;

select customer_id, order_date, max(purchase_amount) as "highest Amount" from orders 
group by customer_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);

select customer_id, order_date, max(purchase_amount) as "highest Amount" from orders 
group by customer_id, order_date;

select customer_id, order_date, max(purchase_amount) as "highest Amount" from orders 
group by customer_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);

