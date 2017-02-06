# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                            bigint auto_increment not null,
  constraint pk_account primary key (id)
);

create table account_details (
  id                            integer auto_increment not null,
  auth_id                       bigint,
  transactiondate               datetime(6),
  vendor                        varchar(255),
  amount                        varchar(255),
  location                      varchar(255),
  constraint pk_account_details primary key (id)
);

create table categories (
  vendor                        varchar(255),
  category                      varchar(255)
);

alter table account_details add constraint fk_account_details_auth_id foreign key (auth_id) references account (id) on delete restrict on update restrict;
create index ix_account_details_auth_id on account_details (auth_id);


# --- !Downs

alter table account_details drop foreign key fk_account_details_auth_id;
drop index ix_account_details_auth_id on account_details;

drop table if exists account;

drop table if exists account_details;

drop table if exists categories;

