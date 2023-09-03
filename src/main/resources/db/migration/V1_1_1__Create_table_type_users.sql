create table type_users(
	cd_type_user serial primary key,
    ds_type_user varchar(250) not null, 
    created_at timestamp with time zone default now(),
    edited_at timestamp with time zone
);

insert into type_users (ds_type_user) values ('Aluno');
insert into type_users (ds_type_user) values ('Professor');
insert into type_users (ds_type_user) values ('Diretor');
insert into type_users (ds_type_user) values ('Admin');

alter table users add column cd_type_user integer null;

alter table users add constraint cd_type_users_fk 
foreign key (cd_type_user) references type_users(cd_type_user); 