create table if not exists school_week(
    id serial primary key,
    start_day date,
    end_day date
)

comment on table school_week is '������� ������� ������';
comment on column school_week.id is '�������������';
comment on column school_week.start_day is '������ ������� ���� ������';
comment on column school_week.end_day is '��������� ������� ���� ������';
