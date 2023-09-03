create table class(
	cd_class serial primary key,
    ds_num_class varchar(100) not null,
    ds_recommended_quarter varchar(5) not null, 
    created_at timestamp with time zone default now(),
    edited_at timestamp with time zone
);

create table class_student(
	cd_class_student serial primary key,
    cd_class integer not null,
    cd_student integer not null,
    created_at timestamp with time zone default now(),
    edited_at timestamp with time zone
);

alter table class_student add constraint student_fk 
foreign key (cd_student) references users(cd_user);

alter table class_student add constraint class_fk 
foreign key (cd_class) references class(cd_class);


create table class_teacher(
	cd_class_teacher serial primary key,
    cd_class integer not null,
    cd_teacher integer not null,
    created_at timestamp with time zone default now(),
    edited_at timestamp with time zone
);

alter table class_teacher add constraint teacher_fk 
foreign key (cd_teacher) references users(cd_user);

alter table class_teacher add constraint class_fk 
foreign key (cd_class) references class(cd_class);