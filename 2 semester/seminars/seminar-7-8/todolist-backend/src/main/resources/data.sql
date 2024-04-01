insert into projects (name, priority) values ('Сконфигурировать тестовую БД', 10);

insert into tasks(text, status, project_id) values ('Установить postgres', 'NEW', 1);
insert into tasks(text, status, project_id) values ('Изменить дефолтные настройки postgres', 'NEW', 1);


insert into projects (name, priority) values ('Написать сервис на Spring Boot', 5);
insert into tasks(text, status, project_id) values ('Настроить datasource в сервисе', 'NEW', 2);