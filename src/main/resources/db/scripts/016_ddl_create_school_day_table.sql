create table if not exists school_day (
     id serial primary key,
     name varchar(256) UNIQUE,
     school_day_date date,
     week_id int references school_week(id)
 );

comment on table school_day is 'Таблица учебных дней';
comment on column school_day.id is 'Идентификатор';
comment on column school_day.name is 'Название';
comment on column school_day.school_day_date is 'Дата';
comment on column school_day.week_id is 'Учебная неделя';
