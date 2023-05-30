insert into role(name) values('Admin') ON CONFLICT DO NOTHING;;
insert into role(name) values('Teacher') ON CONFLICT DO NOTHING;;
insert into role(name) values('Student') ON CONFLICT DO NOTHING;;