create table if not exists class_day_lesson (
    id serial primary key,
    class_day_id int references class_day(id),
    lesson_id int references lesson(id)
);