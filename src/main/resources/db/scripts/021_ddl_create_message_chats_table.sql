CREATE TABLE IF NOT EXISTS chat(
   id serial primary key,
   chat_name varchar(256),
   );


comment on table chat is '������� �����';
comment on column chat.id is '�������� ����';

CREATE TABLE IF NOT EXISTS message(
   id serial primary key,
   sender_id int references users(id),
   receiver_id int references users(id),
   text varchar(16512),
   "timestamp" timestamp without time zone,
);

comment on table message is '������� ���������';
comment on column message.id is '������������� ���������';
comment on table message.sender_id is '����������� ���������';
comment on column message.receiver_id is '���������� ���������';
comment on table message.text is '����� ���������';

CREATE TABLE IF NOT EXISTS chat_message(
   id serial primary key,
   chat_id int references chats(id),
   text varchar(16512),
   "timestamp" timestamp without time zone,
);

comment on table chat_message is '������� ������������� � �����';
comment on column message.id is '������������� ���������';
comment on column chat_message.chat_id is '������������� ����';
comment on table chat_message.text is '����� ���������';
comment on table chat_message."timestamp" is '����� �������� ���������';

CREATE TABLE IF NOT EXISTS user_chat {
    id serial primary key,
    user_id int references users(id),
    chat_id int references chats(id)
};

comment on table user_chat is '������� ������������� � �����';
comment on column user_chat.id is '������������� ���������';
comment on column user_chat.user_id is '������������� ������������';
comment on table user_chat.chat_id is '������������� ����';

CREATE TABLE IF NOT EXISTS notifications {
    id serial primary key,
    user_id int references users(id),
    text varchar(16512),
   "timestamp" timestamp without time zone,
   is_read boolean DEFAULT FALSE;
};

comment on table notifications is '������� �����������';
comment on column notifications.id is '������������� �����������';
comment on column notifications.user_id is '���������� �����������';
comment on table notifications.text is '����� �����������';
comment on table notifications."timestamp" is '����� ��������';
comment on table notifications.is_read is '��������� �� �����������';