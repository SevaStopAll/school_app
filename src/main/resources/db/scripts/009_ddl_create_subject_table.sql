CREATE TABLE if not exists subject (
    id serial primary key,
    name varchar(256) UNIQUE
);

comment on table subject is '������� ���������';
comment on column subject.id is '�������������';
comment on column subject.name is '���';
