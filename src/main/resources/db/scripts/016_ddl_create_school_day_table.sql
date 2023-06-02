create table if not exists school_day (
     id serial primary key,
     name varchar(256) UNIQUE,
     school_day_date date,
     week_id int references school_week(id)
 );