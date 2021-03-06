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
    beer_name varchar(50) not null,
    abv VARCHAR(50),
    ibu VARCHAR(50),
    beer_type varchar(50),
    CONSTRAINT PK_beer PRIMARY KEY(beer_id)
);    

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL sequences IN SCHEMA public
TO final_capstone_appuser;



 
DROP TABLE IF EXISTS beer_manifest CASCADE;
 CREATE TABLE beer_manifest (
        beer_id serial,
        bb_brewery_id serial,
        PRIMARY KEY(beer_id, bb_brewery_id),
        FOREIGN KEY(beer_id) REFERENCES beer(beer_id), 
        FOREIGN KEY(bb_brewery_id) REFERENCES brewery(bb_brewery_id)  
        );   
        
COPY brewery(brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state, county_province, postal_code, website_url, phone, country, longitude, latitude, tags)
FROM 'C:\Users\Kevin\workspace\capstone-nlr4-blue-brewery\java\database\breweries.csv'
DELIMITER ','
CSV HEADER;

grant all on sequence seq_user_id to  final_capstone_appuser;

COMMIT TRANSACTION


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
WHERE brewery_id = '6541'


SELECT *
FROM brewery
WHERE brewery_id LIKE '%sam%'


SELECT beer_id, beer_name, abv, ibu, beer_type
FROM beer
INNER JOIN brewery ON beer.brewery_id = brewery.bb_brewery_id 
WHERE brewery_name = 'Solemn Oath Brewery'

SELECT * 
FROM brewery
WHERE brewery_name LIKE '%Oath%'


INSERT into beer (beer_name, abv, ibu, beer_type)
VALUES ('Were All Misfits', '7' , null , 'Christmas Ale')



INSERT into beer (beer_name, abv, ibu, beer_type)
VALUES ('Twisted Every Way', '6.5' , null , 'IPA')



INSERT into beer (beer_name, abv, ibu, beer_type)
VALUES ('LU', '4.7' , null , 'Kolsch')


INSERT into beer (beer_name, abv, ibu, beer_type)
VALUES ('BudLight', '5.0' , null, null)



delete from brewery
where bb_brewery_id = 8046


UPDATE brewery
SET     brewery_id = 'sams bar', 
        brewery_name = 'tims', 
        brewery_type = null, 
        street = null, 
        address_2 = null, 
        address_3 = null, 
        city = null, 
        state = null, 
        county_province = null, 
        postal_code = null, 
        website_url = null, 
        phone = null, 
        country = null, 
        longitude = null, 
        latitude = null, 
        image_url = null, 
        brewery_desc = null, 
        opening_time = null, 
        closing_time = null, 
        cost_rating = null, 
        noise_rating = null, 
        three_word_desc = null, 
        tags = null
WHERE bb_brewery_id = 1;

        
INSERT into beer_manifest (beer_id, bb_brewery_id)
VALUES ( (SELECT beer_id
          FROM beer
          WHERE beer_name = 'Twisted Every Way'),
          
          (SELECT bb_brewery_id
          FROM brewery
          WHERE brewery_name = '10-56 Brewing Company') );
          
        


SELECT  beer_name, abv, ibu, beer_type
from beer
INNER JOIN beer_manifest ON beer.beer_id = beer_manifest.beer_id
INNER JOIN brewery on beer_manifest.bb_brewery_id = brewery.bb_brewery_id
WHERE brewery_name = '10-56 Brewing Company'
        