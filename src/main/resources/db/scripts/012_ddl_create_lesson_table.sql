create table if not exists lesson(
    id serial primary key,
    lesson_date date,
    number int,
    name varchar(256) UNIQUE,
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
);

comment on table lesson is '������� ������';
comment on column lesson.id is '�������������';
comment on column lesson.lesson_date is '���� ����������';
comment on column lesson.number is '����� ����� � ���������� �� ������� ����������';
comment on column lesson.name is '��������';
comment on column lesson.subject_id is '�������';
comment on column lesson.teacher_id is '�������';
comment on column lesson.school_class_id is '�����';