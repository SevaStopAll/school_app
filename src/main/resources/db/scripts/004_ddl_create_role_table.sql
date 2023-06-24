create table if not exists role(
    id serial primary key,
    name varchar(255) UNIQUE
);

comment on table role is 'Таблица ролей';
comment on column role.id is 'Идентификатор';
comment on column role.name is 'Название роли';