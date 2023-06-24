CREATE TABLE if not exists homework (
    id serial primary key,
    description varchar(1024),
    lesson_id int references lesson(id),
    subject_id int references subject(id),
    school_class_id int references school_class(id)
);

comment on table homework is '������� �������� �������';
comment on column homework.id is '�������������';
comment on column homework.description is '��������';
comment on column homework.lesson_id is '�� ����� ������ ����� ���� ������';
comment on column homework.subject_id is '�������';
comment on column homework.school_class_id is '�����';
