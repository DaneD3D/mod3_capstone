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
        image_url varchar(120),
        
        brewery_desc varchar(250),
        opening_time time(0),
        closing_time time(0),
        cost_rating integer,
        noise_rating integer,
        three_word_desc varchar(20),
        
        tags varchar(10),
	CONSTRAINT PK_brewery PRIMARY KEY(bb_brewery_id)	
        ); 

        
CREATE TABLE beer (
    beer_id serial,
    brewery_id int not null,
    beer_name varchar(50) not null,
    abv decimal not null,
    ibu int,
    beer_type varchar(50),
    CONSTRAINT PK_beer PRIMARY KEY(beer_id),
    CONSTRAINT FK_beer_brewery FOREIGN KEY(brewery_id) REFERENCES brewery(bb_brewery_id)  
);
        

COMMIT TRANSACTION

-- Import breweries. Uncomment and add the ABSOLUTE PATH of the CSV file in FROM

/*
COPY brewery(brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state, county_province, postal_code, website_url, phone, country, longitude, latitude, tags)
FROM 'C:\Users\Student\workspace\capstone-nlr4-blue-brewery\java\database\breweries.csv'
DELIMITER ','
CSV HEADER;
*/

-- Uncomment this and run it in DB Visualizer if we add a table
/*
GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;
*/

--Update all image_urls to placeholder
/*
UPDATE brewery
SET image_url = 'https://picsum.photos/800/600',
brewery_desc = 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Reiciendis
        unde totam nesciunt magni molestiae numquam provident quia explicabo,
        iusto omnis laudantium temporibus? Perferendis exercitationem sapiente
        cupiditate',
opening_time = '09:10:00',
closing_time = '16:30:00',
cost_rating = random() * 2 + 1,
noise_rating = random() * 2 + 1,
three_word_desc = 'Lorem ipsum dolor';
*/


INSERT into beer (brewery_id, beer_name, abv, ibu, beer_type)
VALUES ('1', 'mikes hard', '8' , '7', 'soda')


INSERT into beer (brewery_id, beer_name, abv, ibu, beer_type)
VALUES ('1', 'miller', '8' , '7', 'ale')


UPDATE beer
SET beer_name = 'miller', abv = '3', ibu = '2', beer_type = 'ipa'
WHERE bb_beer_id = 4

INSERT INTO brewery (brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state, county_province, postal_code, website_url, phone, country, longitude, latitude, image_url, brewery_desc, opening_time, closing_time, cost_rating, noise_rating, three_word_desc, tags) 
VALUES ('sams bar', 'sams bar', 'new', '123 fake street', '2', '3', 'chicago', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
 
 
INSERT INTO brewery (brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state) 
VALUES ('sams bar2', 'sams bar2', 'new', '1234 fake street', 'null', 'null', 'chicago', null)



SELECT *
FROM beer
WHERE beer_type = 'soda'




SELECT *
FROM brewery
WHERE brewery_name LIKE '%sam%'


SELECT beer_name
FROM beer
INNER JOIN brewery ON beer.brewery_id = brewery.bb_brewery_id 
WHERE brewery_name = '10-56 Brewing Company'




 
 