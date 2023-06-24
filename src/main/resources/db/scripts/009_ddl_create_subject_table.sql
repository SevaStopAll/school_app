CREATE TABLE if not exists subject (
    id serial primary key,
    name varchar(256) UNIQUE
);

comment on table subject is 'Таблица предметов';
comment on column subject.id is 'Идентификатор';
comment on column subject.name is 'Имя';
