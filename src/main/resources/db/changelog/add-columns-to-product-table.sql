--liquibase formatted sql
--changeset yuliya:add-columns-to-product-table
ALTER TABLE product
ADD COLUMN created_at TIMESTAMP NOT NULL,
ADD COLUMN updated_at TIMESTAMP,
ADD COLUMN calories INTEGER NOT NULL,
ADD COLUMN ingredients VARCHAR(255) NOT NULL;