--liquibase formatted sql
--changeset yuliya:add-unique-constraint-to-product-table
ALTER TABLE product
ADD UNIQUE(name);