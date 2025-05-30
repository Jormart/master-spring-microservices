-- SQL script to populate the user_details table with initial data
insert into user_details (id, name, birth_date) values 
(10001, 'John Doe', '1985-05-15'),
(10002, 'Jane Smith', '1990-10-20'),
(10003, 'Alice Johnson', '1975-03-30'),
(10004, 'Bob Brown', '2000-12-01'),
(10005, 'Charlie White', '1988-07-25');

insert into post(id,description,user_id) values
(20001, 'I want to learn AWS', 10001),
(20002, 'I want to learn DevOps', 10001),
(20003, 'I want to get AWS Certified', 10002),
(20004, 'I want to learn Multi Cloud', 10002),
(20005, 'I want to learn Spring Boot', 10003),
(20006, 'I want to learn Microservices', 10003),
(20007, 'I want to learn Docker', 10004),
(20008, 'I want to learn Kubernetes', 10004),
(20009, 'I want to learn Java', 10005),
(20010, 'I want to learn Python', 10005);
