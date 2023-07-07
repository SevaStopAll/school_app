CREATE TABLE IF NOT EXISTS news(
   id serial primary key,
   header varchar(256),
   description text,
   publication_time timestamp without time zone default (now() at time zone 'utc'),
   user_id int references users(id)
   );


comment on table news is '������� ��������';
comment on column news.id is '������������� �������';
comment on column news.header is '���������';
comment on column news.description is '����� �������';
comment on column news.user_id is '������������, ������������ �������';