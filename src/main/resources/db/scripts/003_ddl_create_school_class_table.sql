CREATE TABLE if not exists school_class (
    id serial primary key,
    name varchar(256) UNIQUE
);

comment on table school_class is '������� �������� �������';
comment on column school_class.id is '�������������';
comment on column school_class.name is '��� �������� � ������ ������';