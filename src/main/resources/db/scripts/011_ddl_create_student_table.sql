  CREATE TABLE if not exists student (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    class_id int references school_class(id),
    user_id int references users(id)
);

comment on table student is '������� ��������';
comment on column student.id is '�������������';
comment on column student.first_name is '���';
comment on column student.last_name is '�������';
comment on column student.class_id is '�����';
comment on column student.user_id is '������������� ������������';