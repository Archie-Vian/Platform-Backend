create table department
(
    id          int8 generated by default as identity,
    created_by  varchar(255),
    modified_by varchar(255),
    department  varchar(255),
    faculty_id  int8,
    primary key (id)
);
create table direction
(
    id             int8 generated by default as identity,
    created_by     varchar(255),
    modified_by    varchar(255),
    direction      varchar(255),
    direction_code varchar(255),
    faculty_id     int8,
    primary key (id)
);
create table discipline
(
    id          int8 generated by default as identity,
    created_by  varchar(255),
    modified_by varchar(255),
    semester    int4 not null,
    subject_id  int8 not null,
    usr_id      int8 not null,
    primary key (id)
);
create table faculty
(
    id              int8 generated by default as identity,
    created_by      varchar(255),
    modified_by     varchar(255),
    faculty_name    varchar(255) not null,
    university_name int8,
    primary key (id)
);
create table place_study
(
    created_by    varchar(255),
    modified_by   varchar(255),
    semester      int4 not null,
    user_id       int8 not null,
    department_id int8 not null,
    direction_id  int8 not null,
    faculty_id    int8 not null,
    team_id       int8 not null,
    university_id int8 not null,
    primary key (user_id)
);
create table schedule_cell
(
    id          int8 generated by default as identity,
    created_by  varchar(255),
    modified_by varchar(255),
    end_class   timestamp,
    start_class timestamp,
    type        varchar(255),
    subject_id  int8,
    team_id     int8,
    primary key (id)
);
create table schedule_user_cell
(
    id              int8 generated by default as identity,
    created_by      varchar(255),
    modified_by     varchar(255),
    university_role varchar(255),
    schedule_cell   int8,
    usr_id          int8,
    discipline_id   int8,
    primary key (id)
);
create table subject
(
    id           int8 generated by default as identity,
    created_by   varchar(255),
    modified_by  varchar(255),
    subject_name varchar(255) not null,
    primary key (id)
);
create table task
(
    id                    int8 generated by default as identity,
    created_by            varchar(255),
    modified_by           varchar(255),
    dead_line             timestamp,
    is_done               boolean      not null,
    mark                  int4,
    task_name             varchar(255) not null,
    schedule_user_cell_id int8,
    primary key (id)
);
create table task_attachment
(
    id           int8 generated by default as identity,
    created_by   varchar(255),
    modified_by  varchar(255),
    content      oid,
    content_type varchar(255),
    file_name    varchar(255),
    task_id      int8,
    primary key (id)
);
create table team
(
    id           int8 generated by default as identity,
    created_by   varchar(255),
    modified_by  varchar(255),
    semester     int8,
    team_name    varchar(255),
    direction_id int8,
    primary key (id)
);
create table university
(
    id          int8 generated by default as identity,
    created_by  varchar(255),
    modified_by varchar(255),
    university  varchar(255),
    primary key (id)
);
create table user_info
(
    created_by  varchar(255),
    modified_by varchar(255),
    first_name  varchar(255) not null,
    img         oid,
    img_name    varchar(255),
    img_type    varchar(255),
    last_name   varchar(255) not null,
    patronymic  varchar(255) not null,
    phone       varchar(255) not null,
    user_id     int8         not null,
    primary key (user_id)
);
create table usr
(
    id              int8 generated by default as identity,
    created_by      varchar(255),
    modified_by     varchar(255),
    email           varchar(255) not null,
    password        varchar(255) not null,
    university_role varchar(255),
    team_id int8,
    primary key (id));

alter table if exists department
    add constraint department_fk
        foreign key (faculty_id)
            references faculty;
alter table if exists direction
    add constraint direction_fk
        foreign key (faculty_id) references faculty on delete cascade;
alter table if exists discipline
    add constraint discipline_to_subject_fk
        foreign key (subject_id) references subject on delete cascade;
alter table if exists discipline
    add constraint discipline_to_usr_fk
        foreign key (usr_id) references usr on delete cascade;
alter table if exists faculty
    add constraint faculty_fk
        foreign key (university_name) references university on delete cascade;
alter table if exists place_study
    add constraint place_study_to_department_fk
        foreign key (department_id) references department on delete cascade;
alter table if exists place_study
    add constraint place_study_to_direction_fk
        foreign key (direction_id) references direction on delete cascade;
alter table if exists place_study
    add constraint place_study_to_faculty_fk
        foreign key (faculty_id) references faculty on delete cascade;
alter table if exists place_study
    add constraint place_study_to_team_fk
        foreign key (team_id) references team on delete cascade;
alter table if exists place_study
    add constraint place_study_to_university_fk
        foreign key (university_id) references university on delete cascade;
alter table if exists place_study
    add constraint place_study_to_usr_fk
        foreign key (user_id) references usr on delete cascade;
alter table if exists schedule_cell
    add constraint schedule_cell_to_subject_fk
        foreign key (subject_id) references subject on delete cascade;
alter table if exists schedule_cell
    add constraint schedule_cell_to_team_fk
        foreign key (team_id) references team on delete cascade;
alter table if exists schedule_user_cell
    add constraint schedule_user_cell_to_schedule_cell_fk
        foreign key (schedule_cell) references schedule_cell on delete cascade;
alter table if exists schedule_user_cell
    add constraint schedule_user_cell_to_usr_fk
        foreign key (usr_id) references usr on delete cascade;
alter table if exists schedule_user_cell
    add constraint schedule_user_cell_to_discipline_fk
        foreign key (discipline_id) references discipline on delete cascade;
alter table if exists task
    add constraint task_fk
        foreign key (schedule_user_cell_id) references schedule_user_cell on delete cascade;
alter table if exists task_attachment
    add constraint task_attachment_fk
        foreign key (task_id) references task on delete cascade;
alter table if exists team
    add constraint team_direction_fk
        foreign key (direction_id) references direction on delete cascade;
alter table if exists user_info
    add constraint user_info_fk
        foreign key (user_id) references usr on delete cascade;
alter table if exists usr
    add constraint usr_fk
        foreign key (team_id) references team on delete cascade;