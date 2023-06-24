create table if not exists mark (
    id serial primary key,
    score_id int references score(id),
    student_id int references student(id),
    subject_id int references subject(id),
    teacher_id int references teacher(id)
);

comment on table mark is '������� ������';
comment on column mark.id is '�������������';
comment on column mark.score_id is '����';
comment on column mark.student_id is '������ ������� ����������';
comment on column mark.subject_id is '�� ������ ��������';
comment on column mark.teacher_id is '�� ������ ������';