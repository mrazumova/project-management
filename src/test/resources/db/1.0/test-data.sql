--liquibase formatted sql

--changeset Razumava_M:20212401-1
insert into department(id, name, description)
values ("66e8ce62-84e5-48ba-86f4-23be8084b5f1", "Department 2", "Project management department");

--changeset Razumava_M:20212401-2
insert into department(id, name, description)
values ("2d3d9bbe-a602-42e1-a5c6-fe154cd26e70", "Department 3", "Software developmant department");

--changeset Razumava_M:20212401-3
insert into unit(id, name, description, department_id)
values ("7551d31b-311a-4c6b-bd7b-584b129a6207", "Unit 1", "backend development", "2d3d9bbe-a602-42e1-a5c6-fe154cd26e70");

--changeset Razumava_M:20212401-4
insert into unit(id, name, description, department_id)
values ("5c8571f2-a42b-4613-b4f2-c6fb61a984cb", "Unit 2", "", "66e8ce62-84e5-48ba-86f4-23be8084b5f1");

--changeset Razumava_M:20212401-5
insert into manager(id, surname, name, post, cv_link, workload, salary, unit_id)
values ("46469615-3cfe-4765-8c79-6584ded16f27", "Ivanov", "Ivan", "PROJECT_MANAGER", "https://resume.com/345230958", 8, 2000, "5c8571f2-a42b-4613-b4f2-c6fb61a984cb");

--changeset Razumava_M:20212401-6
insert into project(id, name, description, type, pricing_model, status, manager_id, support_type)
values ("bca4adcd-f356-4272-b494-ce1633aca085", "my-shop", "online shop", "PRODUCTION", "FIXED_PRICE", "SUPPORT", "46469615-3cfe-4765-8c79-6584ded16f27", "SHORT_TERM");