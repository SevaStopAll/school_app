CREATE TABLE if not exists score (
    id serial primary key,
    description int unique
);

comment on table score is '������� ��������� ������';
comment on column score.id is '�������������';
comment on column score.description is '�������� ������';
