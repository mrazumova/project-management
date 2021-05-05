--liquibase formatted sql

--changeset Razumava_M:20210504-1
create table role
(
    id          varchar(36) not null,
    name        varchar(100),
    description varchar(1000),
    constraint role_pk primary key (id)
);

--changeset Razumava_M:20210504-2
create table permission
(
    id          varchar(36) not null,
    name        varchar(100),
    description varchar(1000),
    constraint permission_pk primary key (id)
);

--changeset Razumava_M:20210504-3
create table role_permission
(
    id            varchar(36) not null,
    permission_id varchar(36),
    role_id       varchar(36),
    constraint role_permission_pk primary key (id)
);

--changeset Razumava_M:20210504-4
insert into permission (id, name, description)
values ('ed417b91-abae-40ac-be0f-49d6e4e25c81', 'READ_DATA', 'Allows access data (people, units, departments)');

--changeset Razumava_M:20210504-5
insert into permission (id, name, description)
values ('65344a4e-7da9-4340-8fa9-05e1c2909ed2', 'EDIT_DATA', 'Allows editing data (people, units, departments)');

--changeset Razumava_M:20210504-6
insert into permission (id, name, description)
values ('ad2e7136-ba50-467c-960d-627483010601', 'READ_PAYMENTS', 'Allows access data about payments');

--changeset Razumava_M:20210504-7
insert into permission (id, name, description)
values ('85401530-e4aa-4ca8-b358-2acd74e8d574', 'EDIT_PAYMENTS', 'Allows editing data about payments');

--changeset Razumava_M:20210504-8
insert into role (id, name, description)
values ('6e1e178a-7521-40d0-8f02-d48437fee0fb', 'ADMIN', 'ADMIN');

--changeset Razumava_M:20210504-9
insert into role(id, name, description)
values ('67a141fa-1bb6-4ea8-b441-6a9003a7abbd', 'MANAGER', 'MANAGER');

--changeset Razumava_M:20210504-10
insert into role(role.id, role.name, role.description)
values ('41d596dc-5ac0-4224-a037-b9d5075031b8', 'USER', 'USER');

--changeset Razumava_M:20210504-11
insert into role_permission(id, permission_id, role_id)
values ('fd363de8-8b75-4e9b-b081-a12f2a8db861', 'ed417b91-abae-40ac-be0f-49d6e4e25c81',
        '6e1e178a-7521-40d0-8f02-d48437fee0fb');

--changeset Razumava_M:20210504-12
insert into role_permission(id, permission_id, role_id)
values ('d0f9a54f-50e8-447d-9902-8cbd1e68301b', 'ed417b91-abae-40ac-be0f-49d6e4e25c81',
        '67a141fa-1bb6-4ea8-b441-6a9003a7abbd');

--changeset Razumava_M:20210504-13
insert into role_permission(id, permission_id, role_id)
values ('058bc0e0-3e9e-4fee-82a2-d858b4a4a83e', 'ed417b91-abae-40ac-be0f-49d6e4e25c81',
        '41d596dc-5ac0-4224-a037-b9d5075031b8');

--changeset Razumava_M:20210504-14
insert into role_permission(id, permission_id, role_id)
values ('9aeb86a0-5494-4870-afa0-9bf0e361ddff', '65344a4e-7da9-4340-8fa9-05e1c2909ed2',
        '6e1e178a-7521-40d0-8f02-d48437fee0fb');

--changeset Razumava_M:20210504-15
insert into role_permission(id, permission_id, role_id)
values ('82b41c63-d852-45d6-b6bf-4f2f8b89c804', 'ad2e7136-ba50-467c-960d-627483010601',
        '6e1e178a-7521-40d0-8f02-d48437fee0fb');

--changeset Razumava_M:20210504-16
insert into role_permission(id, permission_id, role_id)
values ('095ea059-f2cf-4d7d-99de-1f7f7d226fdc', 'ad2e7136-ba50-467c-960d-627483010601',
        '67a141fa-1bb6-4ea8-b441-6a9003a7abbd');

--changeset Razumava_M:20210504-17
insert into role_permission(id, permission_id, role_id)
values ('61419ed6-3cd7-4c45-b9fd-e352471f76ae', '85401530-e4aa-4ca8-b358-2acd74e8d574',
        '6e1e178a-7521-40d0-8f02-d48437fee0fb');