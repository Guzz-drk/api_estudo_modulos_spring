create table users(
	cd_user serial primary key,
	nm_user varchar(250) not null,
	ds_mail varchar(250) not null unique,
	ds_password varchar(250) not null,
	dt_birth date not null,
	created_at timestamp with time zone default now(),
	edited_at timestamp with time zone
);