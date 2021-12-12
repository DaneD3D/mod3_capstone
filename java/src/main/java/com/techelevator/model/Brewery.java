package com.techelevator.model;

import java.sql.Time;
import java.time.LocalTime;

public class Brewery {
      private long bb_brewery_id;
      private String brewery_id;
      private String brewery_name;
      private String brewery_type;
      private String street;
      private String address_2;
      private String address_3;
      private String city;
      private String state;
      private String county_province;
      private String postal_code;
      private String website_url;
      private String phone;
      private String country;
      private String longitude;
      private String latitude;
      private String image_url;
      private String tags;
      private String brewery_desc;
      private Time opening_time;
      private Time closing_time;
      private int cost_rating;
      private int noise_rating;
      private String three_word_Desc;

      public long getBb_brewery_id() {
            return bb_brewery_id;
      }

      public void setBb_brewery_id(long bb_brewery_id) {
            this.bb_brewery_id = bb_brewery_id;
      }

      public String getBrewery_id() {
            return brewery_id;
      }

      public void setBrewery_id(String brewery_id) {
            this.brewery_id = brewery_id;
      }

      public String getBrewery_name() {
            return brewery_name;
      }

      public void setBrewery_name(String brewery_name) {
            this.brewery_name = brewery_name;
      }

      public String getBrewery_type() {
            return brewery_type;
      }

      public void setBrewery_type(String brewery_type) {
            this.brewery_type = brewery_type;
      }

      public String getStreet() {
            return street;
      }

      public void setStreet(String street) {
            this.street = street;
      }

      public String getAddress_2() {
            return address_2;
      }

      public void setAddress_2(String address_2) {
            this.address_2 = address_2;
      }

      public String getAddress_3() {
            return address_3;
      }

      public void setAddress_3(String address_3) {
            this.address_3 = address_3;
      }

      public String getCity() {
            return city;
      }

      public void setCity(String city) {
            this.city = city;
      }

      public String getState() {
            return state;
      }

      public void setState(String state) {
            this.state = state;
      }

      public String getCounty_province() {
            return county_province;
      }

      public void setCounty_province(String county_province) {
            this.county_province = county_province;
      }

      public String getPostal_code() {
            return postal_code;
      }

      public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
      }

      public String getWebsite_url() {
            return website_url;
      }

      public void setWebsite_url(String website_url) {
            this.website_url = website_url;
      }

      public String getPhone() {
            return phone;
      }

      public void setPhone(String phone) {
            this.phone = phone;
      }

      public String getCountry() {
            return country;
      }

      public void setCountry(String country) {
            this.country = country;
      }

      public String getLongitude() {
            return longitude;
      }

      public void setLongitude(String longitude) {
            this.longitude = longitude;
      }

      public String getLatitude() {
            return latitude;
      }

      public void setLatitude(String latitude) {
            this.latitude = latitude;
      }

      public String getImage_url() {
            return image_url;
      }

      public void setImage_url(String image_url) {
            this.image_url = image_url;
      }

      public String getTags() {
            return tags;
      }

      public void setTags(String tags) {
            this.tags = tags;
      }

      public String getBrewery_desc() {
            return brewery_desc;
      }

      public void setBrewery_desc(String brewery_desc) {
            this.brewery_desc = brewery_desc;
      }

      public Time getOpening_time() {
            return opening_time;
      }

      public void setOpening_time(Time opening_time) {
            this.opening_time = opening_time;
      }

      public Time getClosing_time() {
            return closing_time;
      }

      public void setClosing_time(Time closing_time) {
            this.closing_time = closing_time;
      }

      public Integer getCost_rating() {
            return cost_rating;
      }

      public void setCost_rating(Integer cost_rating) {
            this.cost_rating = cost_rating;
      }

      public Integer getNoise_rating() {
            return noise_rating;
      }

      public void setNoise_rating(Integer noise_rating) {
            this.noise_rating = noise_rating;
      }

      public String getThree_word_Desc() {
            return three_word_Desc;
      }

      public void setThree_word_Desc(String three_word_Desc) {
            this.three_word_Desc = three_word_Desc;
      }

      public Brewery() {
            //no-arg constructor
      }

      // 10-56-brewing-company-knox	10-56 Brewing Company	micro	400 Brown Cir	(null)	(null)	Knox	Indiana	(null)	46534	(null)	6308165790	United States	-86.627954	41.289715	(null)




      @Override
      public String toString() {
            return "Brewery{" +
                    "bb_brewery_id=" + bb_brewery_id +
                    ", brewery_id='" + brewery_id + '\'' +
                    ", brewery_name='" + brewery_name + '\'' +
                    ", brewery_type='" + brewery_type + '\'' +
                    ", street='" + street + '\'' +
                    ", address_2='" + address_2 + '\'' +
                    ", address_3='" + address_3 + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", county_province='" + county_province + '\'' +
                    ", postal_code='" + postal_code + '\'' +
                    ", country='" + country + '\'' +
                    ", longitude='" + longitude + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", phone='" + phone + '\'' +
                    ", website_url='" + website_url + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", tag='" + tags + '\'' +
                    '}';
      }

}

