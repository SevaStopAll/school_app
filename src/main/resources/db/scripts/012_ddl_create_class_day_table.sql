create table if not exists class_day (
    id serial primary key,
    name varchar(256),
    school_class_id int references school_class(id),
    school_day_id int references school_day(id)
)