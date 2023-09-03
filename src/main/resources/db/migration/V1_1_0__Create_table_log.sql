create table log(
	cd_log serial primary key,
    cd_user integer not null, 
    ds_response text,
    ds_request text,
    created_at timestamp with time zone default now(),
    edited_ate timestamp with time zone
);

alter table users add constraint cd_users_fk foreign key (cd_user) references users(cd_user); 