create table if not exists public.persons (
    id serial primary key ,
    first_name varchar(1024),
    second_name varchar(1024),
    patronymic varchar(1024),
    email varchar(1024),
    phone_number integer
                            )