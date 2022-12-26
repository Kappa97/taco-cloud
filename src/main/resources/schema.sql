create table if not exists Ingredient
(
    id   varchar(4) PRIMARY KEY not null,
    name varchar(25)            not null,
    type varchar(10)            not null
);
create table if not exists Taco
(
    id        identity PRIMARY KEY,
    name      varchar(50) not null,
    createdAt timestamp   not null
);
create table if not exists Taco_Ingredients
(
    taco       bigint     not null,
    ingredient varchar(4) not null,
    CONSTRAINT FK_Taco FOREIGN KEY (taco) REFERENCES Taco (id),
    CONSTRAINT FK_Ingredients FOREIGN KEY (ingredient) REFERENCES Ingredient (id)
);

create table if not exists Taco_Order
(
    id           identity PRIMARY KEY,
    name         varchar(50) not null,
    street       varchar(50) not null,
    city         varchar(50) not null,
    state        varchar(50) not null,
    zip          varchar(10) not null,
    ccNumber     varchar(16) not null,
    ccExpiration varchar(5)  not null,
    ccCVV        varchar(3)  not null,
    placedAt     timestamp   not null
);
create table if not exists Taco_Order_Tacos
(
    tacoOrder bigint not null,
    taco      bigint not null,
    CONSTRAINT FK_tacoOrder FOREIGN KEY (tacoOrder) REFERENCES Taco_Order (id),
    CONSTRAINT FK_taco_2 FOREIGN KEY (taco) REFERENCES Taco (id)
);
-- create table if not exists User
-- (
--     id          identity PRIMARY KEY,
--     username    varchar(64) not null,
--     password    varchar(64) not null,
--     fullname    varchar(64) not null,
--     street      varchar(64) not null,
--     city        varchar(64) not null,
--     state       varchar(64) not null,
--     zip         varchar(64) not null,
--     phoneNumber varchar(64) not null
-- );
