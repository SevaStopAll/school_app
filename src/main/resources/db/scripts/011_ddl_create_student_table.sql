  CREATE TABLE if not exists student (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    class_id int references school_class(id),
    user_id int references users(id)
);

comment on table student is 'Таблица учеников';
comment on column student.id is 'Идентификатор';
comment on column student.first_name is 'Имя';
comment on column student.last_name is 'Фамилия';
comment on column student.class_id is 'Класс';
comment on column student.user_id is 'Идентификатор пользователя';