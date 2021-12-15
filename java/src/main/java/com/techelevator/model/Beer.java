package com.techelevator.model;

public class Beer {
    private String beer_id;
    private String beer_name;
    private String abv;
    private String ibu;
    private String beer_type;

    public Beer(){
        //no-arg constructor
    }

    public String getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(String beer_id) {
        this.beer_id = beer_id;
    }
    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String beer_name) {
        this.beer_name = beer_name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getBeer_type() {
        return beer_type;
    }

    public void setBeer_type(String beer_type) {
        this.beer_type = beer_type;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beer_id='" + beer_id + '\'' +
                ", beer_name='" + beer_name + '\'' +
                ", abv='" + abv + '\'' +
                ", ibu='" + ibu + '\'' +
                ", beer_type='" + beer_type + '\'' +
                '}';
    }
}
