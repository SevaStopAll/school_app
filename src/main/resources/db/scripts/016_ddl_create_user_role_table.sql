create table if not exists user_role(
    id serial primary key,
    user_id int references users(id),
    role_id int references role(id)
);