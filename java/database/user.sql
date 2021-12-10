-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

DROP TABLE IF EXISTS brewery;
CREATE TABLE brewery (
        brewery_id varchar(80),
        --owner_id int not null,
        brewery_name varchar(80),
        brewery_type varchar(20),
        street varchar(100),
        address_2 varchar(50),
        address_3 varchar(50),
        city varchar(50),
        state varchar(25),
        county_province varchar(30),
        postal_code varchar(11),
        website_url varchar(120),
        phone varchar(50),
        country varchar(30),
        longitude varchar(30),
        latitude varchar(30),
        tags varchar(10),
        image_url varchar(100)
        );
        

        
INSERT INTO beer  (beer_id, brewery_id, beer_name, abv, ibu, beer_type)
VALUES (?, ?, ?, ?, ?, ?);
