
create table user (id integer not null AUTO_INCREMENT, password varchar(255), roles varchar(255), user_name varchar(255), primary key (id));
INSERT INTO user 
  (user_name, password) 
  VALUES('test','pwd123'),('test1','pwd12345');
  
create table task (task_id integer not null AUTO_INCREMENT, create_time timestamp, created_by varchar(255), description varchar(255), last_update timestamp, task_name varchar(255), id integer not null, primary key (task_id));
alter table task add constraint FK1 foreign key (id) references user;

