ALTER TABLE public.homework
    ADD COLUMN teacher_id int references teacher(id);