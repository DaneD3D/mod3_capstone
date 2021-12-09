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
        brewery_id int not null,
        --owner_id int not null,
        brewery_name varchar(80) not null,
        brewery_type varchar(20) not null,
        street varchar(50) not null,
        address_2 varchar(50),
        address_3 varchar(50),
        city varchar(50) not null,
        state varchar(25) not null,
        county_province varchar(30),
        postal_code varchar(11) not null,
        website_url varchar(100),
        phone varchar(15),
        country varchar(30),
        longitude varchar(30),
        latitude varchar(30),
        tags varchar(10)
        
        --PRIMARY KEY (brewery_id),
        --FOREIGN KEY (owner_id) REFERENCES users(user_id)
        
        ); 
        
        --\COPY <table name> FROM 'C:\Users\Student\Desktop\breweries.csv' DELIMITER ',' CSV HEADER;
