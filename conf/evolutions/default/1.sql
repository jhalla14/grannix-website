# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table my_user (
  email                     varchar(255),
  fullname                  varchar(255),
  is_admin                  boolean)
;




# --- !Downs

drop table if exists my_user cascade;

