create table account(
    id serial primary key,
    name varchar (100) not null,
    create_date timestamp not null,
    update_date timestamp not null
);
create table client(
    id serial primary key,
    name varchar (100) not null,
    password varchar (100),
    uuid varchar(50),
    have_access boolean,
    descp text,
    client_type varchar(25),
    create_date timestamp not null,
    update_date timestamp not null
);
/*alter table client add acc_id int;
alter table client alter column acc_id type int using acc_id::int*/
create table client_info
(
    id  serial primary key,
    create_date timestamp,
    email       varchar(255),
    client_id   integer
);

create table client_account
(
  client_id int references client(id),
  account_id int references account(id)
);

alter table account add column client_id;
create sequence seq_account start 1;
create sequence seq_client start 1;
create sequence seq_client_info start 1;
alter table account add column password varchar(100);
SELECT * FROM client;
alter sequence seq_client restart 1;
alter sequence seq_account restart 1;
alter sequence seq_client_info restart 1;
alter sequence account_id_seq restart 1;
alter sequence client_id_seq restart 1;
alter sequence client_info_id_seq restart 1