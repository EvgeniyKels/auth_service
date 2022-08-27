create database if not exists auth default character set utf8mb4 collate utf8mb4_0900_ai_ci;

create table if not exists clients
(
    client_db_id             varchar(32)  not null
        primary key,
    client_id                varchar(100) not null,
    client_id_issued_at      int          not null,
    client_secret            varchar(250) null,
    client_secret_expires_at int          not null,
    client_name              varchar(250) not null,
    client_auth_methods      varchar(350) not null,
    auth_grant_types         varchar(350) not null,
    redirect_uris            varchar(350) not null,
    scopes                   varchar(350) not null,
    client_settings          blob         not null,
    token_settings           blob         null,
    constraint clients_client_db_id_uindex
        unique (client_db_id),
    constraint clients_client_id_uindex
        unique (client_id),
    constraint clients_client_name_uindex
        unique (client_name)
);

create table if not exists users
(
    user_id                    varchar(32)   not null
        primary key,
    user_name                  varchar(100)  not null,
    password                   varchar(100)  not null,
    is_expired                 tinyint(1)    not null,
    is_non_locked              tinyint(1)    not null,
    is_credentials_non_expired tinyint(1)    not null,
    is_enabled                 tinyint(1)    not null,
    authorities                varchar(1000) not null,
    constraint users_password_uindex
        unique (password),
    constraint users_user_id_uindex
        unique (user_id),
    constraint users_user_name_uindex
        unique (user_name)
);

create table if not exists additional_user_info
(
    user_info_id varchar(32) not null
        primary key,
    user_id      varchar(32) not null,
    user_email   int         null,
    client_type  varchar(50) not null,
    constraint additional_user_info_user_id_uindex
        unique (user_id),
    constraint additional_user_info_user_info_id_uindex
        unique (user_info_id),
    constraint additional_user_info_users_user_id_fk
        foreign key (user_info_id) references users (user_id)
            on update cascade
);