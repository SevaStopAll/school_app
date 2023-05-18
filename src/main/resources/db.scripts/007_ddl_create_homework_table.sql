  CREATE TABLE homework (
    id serial primary key not null,
    description varchar(1024),
    subject_id references subject(id),
    class_id references school_class(id)
);