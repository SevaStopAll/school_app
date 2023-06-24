create table if not exists users(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    login varchar(255) UNIQUE,
    password varchar(255),
    confirmed boolean not null
);

comment on table users is '������� �������������';
comment on column users.id is '�������������';
comment on column users.first_name is '���';
comment on column users.last_name is '�������';
comment on column users.email is '����������� �����';
comment on column users.login is '�����';
comment on column users.password is '������';
comment on column users.confirmed is '������������� ������� ������ ���������������';
