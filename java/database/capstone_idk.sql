DROP TABLE IF EXISTS beer;
CREATE TABLE beer (
    beer_id int not null,
    brewery_id int not null,
    beer_name varchar(50) not null,
    abv decimal not null,
    ibu int,
    beer_type varchar(50)
    --CONSTRAINT pk_beer_id PRIMARY KEY (beer_id),
    --FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

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
        tags varchar(10)
        ); 

       
COPY brewery(brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, state, county_province, postal_code, website_url, phone, country, longitude, latitude, tags)
FROM 'C:\Users\ngond\workspace\capstone-nlr4-blue-brewery\java\database\breweries.csv'
DELIMITER ','
CSV HEADER;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

SELECT *
FROM brewery
WHERE brewery_name = ?;

1188 Brewing Co