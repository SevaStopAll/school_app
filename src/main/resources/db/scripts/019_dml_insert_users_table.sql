insert into users(first_name, last_name, email, login, password, confirmed) values('admin', 'admin', 'admin@admin', 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', true) on conflict do nothing;
insert into user_role(user_id, role_id) values(1,1) on conflict do nothing;