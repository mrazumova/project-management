--liquibase formatted sql

--changeset Razumava_M:20210401-1
create table `developer`
(
    `id`             varchar(36) primary key,
    `surname`        varchar(50),
    `name`           varchar(50),
    `specialization` varchar(50),
    `level`          varchar(50),
    `cv_link`        varchar(255),
    `workload`       int,
    `salary`         int,
    `project_id`     varchar(36),
    `unit_id`        varchar(36)
);

--changeset Razumava_M:20210401-2
create table `manager`
(
    `id`       varchar(36) primary key,
    `surname`  varchar(50),
    `name`     varchar(50),
    `post`     varchar(100),
    `cv_link`  varchar(255),
    `workload` int,
    `salary`   int,
    `unit_id`  varchar(36)
);

--changeset Razumava_M:20210401-3
create table `project`
(
    `id`            varchar(36) primary key,
    `name`          varchar(100),
    `description`   varchar(255),
    `type`          varchar(20),
    `pricing_model` varchar(20),
    `status`        varchar(20),
    `manager_id`    varchar(36),
    `started`       datetime,
    `finished`      datetime,
    `support_type`  varchar(20)
);

--changeset Razumava_M:20210401-4
create table `project_analytics`
(
    `id`               varchar(36) primary key,
    `project_id`       varchar(36),
    `forecasted_cost`  bigint,
    `already_spent`    bigint,
    `already_received` bigint
);

--changeset Razumava_M:20210401-5
create table `expense_history`
(
    `id`           varchar(36) primary key,
    `amount`       bigint,
    `expense_date` datetime,
    `project_id`   varchar(36)
);

--changeset Razumava_M:20210401-6
create table `payment_history`
(
    `id`           varchar(36) primary key,
    `amount`       bigint,
    `payment_date` datetime,
    `project_id`   varchar(36)
);

--changeset Razumava_M:20210401-7
create table `unit`
(
    `id`            varchar(36) primary key,
    `name`          varchar(100),
    `description`   varchar(255),
    `department_id` varchar(36)
);

--changeset Razumava_M:20210401-8
create table `department`
(
    `id`          varchar(36) primary key,
    `name`        varchar(100),
    `description` varchar(255)
);