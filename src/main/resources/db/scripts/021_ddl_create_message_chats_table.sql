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
    is_read boolean DEFAULT FALSE
);

comment on table message is 'Таблица сообщений';
comment on column message.id is 'Идентификатор сообщения';
comment on table message.sender_id is 'Отправитель сообшения';
comment on column message.receiver_id is 'Получатель сообщения';
comment on table message.text is 'Текст сообщения';

comment on table chat is 'Таблица чатов';
comment on column chat.id is 'Название чата';

comment on table chat_message is 'Таблица пользователей и чатов';
comment on column chat_message.id is 'Идентификатор сообщения';
comment on column chat_message.chat_id is 'Идентификатор чата';
comment on table chat_message.text is 'Текст сообшения';
comment on table chat_message."timestamp" is 'Время отправки сообщения';

comment on table user_chat is 'Таблица пользователей и чатов';
comment on column user_chat.id is 'Идентификатор сообщения';
comment on column user_chat.user_id is 'Идентификатор пользователя';
comment on table user_chat.chat_id is 'Идентификатор чата';

comment on table notifications is 'Таблица уведомлений';
comment on column notifications.id is 'Идентификатор уведомления';
comment on column notifications.user_id is 'Получатель уведомления';
comment on table notifications.text is 'Текст уведомления';
comment on table notifications."timestamp" is 'Время отправки';
comment on table notifications.is_read is 'Прочитано ли уведомление';