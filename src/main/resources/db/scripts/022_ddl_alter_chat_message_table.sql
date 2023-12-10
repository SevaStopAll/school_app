ALTER TABLE public.chat_message
    ADD COLUMN sender_id int references users(id);