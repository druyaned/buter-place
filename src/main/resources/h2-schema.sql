create table if not exists Ingredient (
    id varchar(4) not null primary key,
    name varchar(255) not null,
    type varchar(31) not null
);
create table if not exists Ingredient_Ref (
    ingredient_id varchar(4) not null,
    buter bigint not null,
    buter_key bigint not null
);
create table if not exists Buter (
    id identity primary key,
    created_at timestamp not null,
    name varchar(255) not null,
    buter_order bigint not null,
    buter_order_key bigint not null
);
create table if not exists Buter_Order (
    id identity primary key,
    created_at timestamp not null,
    username varchar(255) not null,
    recipient varchar(255) not null,
    delivery_address varchar(255) not null,
    card_number varchar(255) not null,
    card_expiration varchar(255) not null,
    card_cvv varchar(255) not null
);
create table if not exists Buter_User (
    id identity primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    address varchar(255) not null,
    phone_number varchar(255) not null
);
alter table Buter add foreign key (buter_order) references Buter_Order(id);
alter table Ingredient_Ref add foreign key (ingredient_id) references Ingredient(id);
