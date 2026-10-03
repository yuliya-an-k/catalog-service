--liquibase formatted sql
--changeset gps:init-db
CREATE TABLE product
(id UUID NOT NULL,
name VARCHAR(100) NOT NULL,
price NUMERIC(19,4) NOT NULL,
available BOOLEAN NOT NULL DEFAULT FALSE,
CONSTRAINT pk_product PRIMARY KEY (id)

);

