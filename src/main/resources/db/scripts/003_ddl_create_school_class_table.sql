CREATE TABLE if not exists school_class (
    id serial primary key,
    name varchar(256) UNIQUE
);

comment on table school_class is 'Таблица школьных классов';
comment on column school_class.id is 'Идентификатор';
comment on column school_class.name is 'Год обучения и литера класса';