CREATE TABLE IF NOT EXISTS news(
   id serial primary key,
   header varchar(256),
   description text,
   publication_time timestamp without time zone default (now() at time zone 'utc'),
   user_id int references users(id)
   );


comment on table news is 'Таблица новостей';
comment on column news.id is 'Идентификатор новости';
comment on column news.header is 'Заголовок';
comment on column news.description is 'Текст новости';
comment on column news.user_id is 'Пользователь, разместивший новость';