package com.techelevator.model;

public class Brewery {
      private Long id;
      private String name;
      private String brewery_type;
      private String street;
      private String address_2;
      private String address_3;
      private String city;
      private String state;
      private String county_province;
      private int postal_code;
      private String country;
      private double longitude;
      private double latitude;
      private int phone;
      private String website_url;

      public Brewery() {
            //no-arg constructor
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
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

      public int getPostal_code() {
            return postal_code;
      }

      public void setPostal_code(int postal_code) {
            this.postal_code = postal_code;
      }

      public String getCountry() {
            return country;
      }

      public void setCountry(String country) {
            this.country = country;
      }

      public double getLongitude() {
            return longitude;
      }

      public void setLongitude(double longitude) {
            this.longitude = longitude;
      }

      public double getLatitude() {
            return latitude;
      }

      public void setLatitude(double latitude) {
            this.latitude = latitude;
      }

      public int getPhone() {
            return phone;
      }

      public void setPhone(int phone) {
            this.phone = phone;
      }

      public String getWebsite_url() {
            return website_url;
      }

      public void setWebsite_url(String website_url) {
            this.website_url = website_url;
      }
}

