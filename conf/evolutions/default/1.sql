# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table my_user (
  email                     varchar(255) not null,
  fullname                  varchar(255),
  is_admin                  boolean,
  constraint pk_my_user primary key (email))
;

create sequence my_user_seq;




# --- !Downs

drop table if exists my_user cascade;

drop sequence if exists my_user_seq;

