create table school_day_lesson (
    id serial primary key,
    school_day_id int references school_day(id),
    lesson_id int references lesson(id)
)