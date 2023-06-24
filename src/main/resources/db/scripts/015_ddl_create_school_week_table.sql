create table if not exists school_week(
    id serial primary key,
    start_day date,
    end_day date
)

comment on table school_week is 'Таблица учебных недель';
comment on column school_week.id is 'Идентификатор';
comment on column school_week.start_day is 'Первый учебный день недели';
comment on column school_week.end_day is 'Последний учебный день недели';
