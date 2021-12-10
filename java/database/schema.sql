BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS brewery CASCADE;
DROP TABLE IF EXISTS beer CASCADE;


CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


CREATE TABLE brewery (
	bb_brewery_id serial,
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
        image_url varchar(50),
        tags varchar(10),
	CONSTRAINT PK_brewery PRIMARY KEY(bb_brewery_id)	
        ); 

        
CREATE TABLE beer (
    bb_beer_id serial,
    beer_id int not null,
    brewery_id int not null,
    beer_name varchar(50) not null,
    abv decimal not null,
    ibu int,
    beer_type varchar(50),
    CONSTRAINT PK_beer PRIMARY KEY(bb_beer_id),
    CONSTRAINT FK_beer_brewery FOREIGN KEY(bb_beer_id) REFERENCES brewery(bb_brewery_id)  
);
        

COMMIT TRANSACTION;

-- Import breweries. Uncomment and add the ABSOLUTE PATH of the CSV file in FROM

/*    
COPY brewery(brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state, county_province, postal_code, website_url, phone, country, longitude, latitude, tags)
FROM 'C:\Users\ngond\workspace\capstone-nlr4-blue-brewery\java\database\breweries.csv'
DELIMITER ','
CSV HEADER;
*/

-- Uncomment this and run it in DB Visualizer if we add a table
/*
GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;
*/

