  CREATE TABLE if not exists teacher (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    user_id int references users(id)
);

comment on table teacher is '������� ��������';
comment on column teacher.id is '�������������';
comment on column teacher.first_name is '���';
comment on column teacher.last_name is '�������';
comment on column teacher.email is '����������� �����';
