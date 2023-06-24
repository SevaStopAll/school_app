CREATE TABLE if not exists score (
    id serial primary key,
    description int unique
);

comment on table score is 'Таблица вариантов оценки';
comment on column score.id is 'Идентификатор';
comment on column score.description is 'Описание оценки';
