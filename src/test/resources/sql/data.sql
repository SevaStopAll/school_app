CREATE TABLE if not exists score (
    id serial primary key,
    description int unique
);

insert into score(description) values(1) ON CONFLICT DO NOTHING;
insert into score(description) values(2) ON CONFLICT DO NOTHING;
insert into score(description) values(3) ON CONFLICT DO NOTHING;
insert into score(description) values(4) ON CONFLICT DO NOTHING;
insert into score(description) values(5) ON CONFLICT DO NOTHING;

CREATE TABLE if not exists school_class (
    id serial primary key,
    name varchar(256) UNIQUE
);

create table if not exists role(
    id serial primary key,
    name varchar(255) UNIQUE
);

insert into role(name) values('Admin') ON CONFLICT DO NOTHING;
insert into role(name) values('Teacher') ON CONFLICT DO NOTHING;
insert into role(name) values('Student') ON CONFLICT DO NOTHING;

create table if not exists users(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    login varchar(255) UNIQUE,
    password varchar(255),
    confirmed boolean not null
);

create table if not exists user_role(
    id serial primary key,
    user_id int references users(id),
    role_id int references role(id)
);

  CREATE TABLE if not exists teacher (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    user_id int references users(id)
);

CREATE TABLE if not exists subject (
    id serial primary key,
    name varchar(256) UNIQUE
);

CREATE TABLE if not exists subject_teacher(
    id serial primary key,
    subject_id int not null references subject(id),
    teacher_id int not null references teacher(id)
);

  CREATE TABLE if not exists student (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    class_id int references school_class(id),
    user_id int references users(id)
);

create table if not exists lesson(
    id serial primary key,
    lesson_date date,
    number int,
    name varchar(256) UNIQUE,
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
);

CREATE TABLE if not exists homework(
    id serial primary key,
    description varchar(1024),
    lesson_id int references lesson(id),
    subject_id int references subject(id),
    school_class_id int references school_class(id),
    teacher_id int references teacher(id)
);

create table if not exists mark (
    id serial primary key,
    score_id int references score(id),
    student_id int references student(id),
    subject_id int references subject(id),
    teacher_id int references teacher(id)
);

create table if not exists school_week(
    id serial primary key,
    start_day date,
    end_day date
);

create table if not exists school_day (
     id serial primary key,
     name varchar(256) UNIQUE,
     school_day_date date,
     week_id int references school_week(id)
 );

create table if not exists class_day (
    id serial primary key,
    name varchar(256) UNIQUE,
    class_day_date date,
    school_class_id int references school_class(id),
    school_day_id int references school_day(id)
);

 create table if not exists class_day_lesson (
     id serial primary key,
     class_day_id int references class_day(id),
     lesson_id int references lesson(id)
 );
