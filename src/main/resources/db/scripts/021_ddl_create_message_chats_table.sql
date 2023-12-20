CREATE TABLE IF NOT EXISTS message(
    id serial primary key,
    sender_id int references users(id),
    receiver_id int references users(id),
    text varchar(16512),
    "timestamp" timestamp without time zone
    );

CREATE TABLE IF NOT EXISTS chat(
   id serial primary key,
   chat_name varchar(256)
   );

CREATE TABLE IF NOT EXISTS chat_message(
   id serial primary key,
   chat_id int references chat(id),
   text varchar(16512),
   "timestamp" timestamp without time zone
);

CREATE TABLE IF NOT EXISTS user_chat (
    id serial primary key,
    user_id int references users(id),
    chat_id int references chat(id)
    );

CREATE TABLE IF NOT EXISTS notifications (
    id serial primary key,
    user_id int references users(id),
    text varchar(16512),
    "timestamp" timestamp without time zone,
    "read" boolean DEFAULT FALSE
);

