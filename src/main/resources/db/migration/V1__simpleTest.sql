create table criminal_case
(
    id                       bigint       not null,
    name                     varchar(255) not null,
    time_stamp               bigint       not null,
    criminal_case_detail1_id bigint       not null,
    primary key (id)
);
create table criminal_case_detail
(
    id                     bigint       not null,
    objective_description  varchar(255) not null,
    subjective_description varchar(255) not null,
    primary key (id)
);
create table procuarotate
(
    id   bigint      not null,
    name varchar(50) not null,
    primary key (id)
);
create table procurator
(
    id         bigint       not null,
    name       varchar(255) not null,
    primary key (id)
);
alter table criminal_case_detail
    drop constraint if exists UK_ek824eobosixl8pcv2q1f69fc;
alter table criminal_case_detail
    add constraint UK_ek824eobosixl8pcv2q1f69fc unique (objective_description);
create
sequence hibernate_sequence start
with 1 increment by 1;
alter table criminal_case
    add constraint FKju8bbe7l5yrf06ws9w3lxlpvf foreign key (criminal_case_detail1_id) references criminal_case_detail;