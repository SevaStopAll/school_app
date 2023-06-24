create table if not exists users(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    login varchar(255) UNIQUE,
    password varchar(255),
    confirmed boolean not null
);

comment on table users is 'Таблица пользователей';
comment on column users.id is 'Идентификатор';
comment on column users.first_name is 'Имя';
comment on column users.last_name is 'Фамилия';
comment on column users.email is 'Электронная почта';
comment on column users.login is 'Логин';
comment on column users.password is 'Пароль';
comment on column users.confirmed is 'Подтверждение учетной записи администратором';
