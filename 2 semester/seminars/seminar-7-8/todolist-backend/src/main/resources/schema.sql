create table if not exists projects(id SERIAL PRIMARY KEY, name VARCHAR, priority INT);

create table if not exists tasks(id SERIAL PRIMARY KEY, text VARCHAR, status VARCHAR, project_id BIGINT);

create table config(cfg_key VARCHAR, cfg_value VARCHAR);

INSERT INTO config('PROJECTS_MAX_COUNT', 10);

alter table tasks add constraint projects_fk_id foreign key(project_id) references projects(id);