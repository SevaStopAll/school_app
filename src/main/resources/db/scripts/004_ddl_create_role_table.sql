create table if not exists role(
    id serial primary key,
    name varchar(255) UNIQUE
);

comment on table role is '������� �����';
comment on column role.id is '�������������';
comment on column role.name is '�������� ����';