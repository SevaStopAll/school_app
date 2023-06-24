create table if not exists school_day (
     id serial primary key,
     name varchar(256) UNIQUE,
     school_day_date date,
     week_id int references school_week(id)
 );

comment on table school_day is '������� ������� ����';
comment on column school_day.id is '�������������';
comment on column school_day.name is '��������';
comment on column school_day.school_day_date is '����';
comment on column school_day.week_id is '������� ������';
