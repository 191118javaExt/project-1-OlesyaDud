drop schema if exists projectone cascade;
drop table if exists projectone.reimb_type cascade;
drop table if exists projectone.user_role cascade;
drop table if exists projectone.reimb_status cascade;
drop table if exists projectone.user0 cascade;
drop table if exists projectone.reimbursement cascade;

create schema projectone;

create table projectone.reimb_status (
status_id serial primary key,
reimb_status varchar(50)
);

create table projectone.reimb_type (
type_id serial primary key,
reimb_type varchar(50)
);

create table projectone.user_role (
role_id serial primary key,
user_role varchar(50)
);

create table projectone.user0 (
user_id serial primary key,
username varchar(50) not null,
user_passward varchar(50) not null,
user_fname varchar(100) not null,
user_lname varchar(100) not null,
user_email varchar(150) not null,
user_role_id integer references projectone.user_role(role_id)
);

create table projectone.reimbursement (
reimb_id serial primary key,
reimb_amount serial not null,
reimb_submitted timestamp not null,
reimb_resolved timestamp not null,
reimb_description varchar(250),
reimb_receit bytea null,
reimb_author integer references projectone.user0(user_id),
reimb_resolver integer references projectone.user0(user_id),
reimb_status_id integer references projectone.reimb_status(status_id),
reimb_type_id integer references projectone.reimb_type(type_id)
);
 
insert into projectone.user_role (user_role)
values 
('manager'),
('employee');

insert into projectone.reimb_status(reimb_status)
values 
('pending'),
('approved'),
('denied');

insert into projectone.reimb_type(reimb_type)
values 
('lodging'),
('travel'),
('food'),
('other');

insert into projectone.user0(username, user_email, user_passward, user_fname, user_lname, user_role_id)
values 
('Nina', 'nina@gmail.com', '111222', 'Nina', 'K', 2 ),
('manager', 'manager@gmail.com', '222333', 'manager1', 's', 1 );

insert into projectone.reimbursement(reimb_amount, reimb_submitted, reimb_resolved, 
reimb_description, reimb_receit, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
values 
('200', '01/02/2020 12:00:00', '01/03/2020 01:00:00', 'travel', 'no', 1, 2, 1, 2),
('100', '01/02/2020 12:00:00', '01/03/2020 01:00:00', 'food', 'no', 1, 2, 1, 3),
('500', '01/02/2020 12:00:00', '01/03/2020 01:00:00', 'lodging', 'no', 1, 2, 2, 1);
