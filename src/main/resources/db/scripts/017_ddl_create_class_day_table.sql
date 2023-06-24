create table if not exists class_day (
    id serial primary key,
    name varchar(256) UNIQUE,
    class_day_date date,
    school_class_id int references school_class(id),
    school_day_id int references school_day(id)
);

comment on table class_day is '������� ���������� ��� ������ �� ������� ����';
comment on column class_day.id is '�������������';
comment on column class_day.name is '��������';
comment on column class_day.class_day_date is '����';
comment on column class_day.school_class_id is '�����';
comment on column class_day.school_day_id is '������� ����';
