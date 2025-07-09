package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "neighborhoods")
public class Neighbor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "State name must be filled")
    public String place;

    @NotBlank(message = "Area name must be filled according to the State")
    public String Neighborhood;

    @Min(value = 1500, message = "Average rent should atleast > 1500")
    public int avg_rent;

    @Min(value = 1, message = "This should be > 1" )
    public int safety; // Higher people = safer

    @Min(value = 1, message = "This should be > 1" )
    public int nightlife; // hangouts

    @Min(value = 1, message = "This should be > 1" )
    public int schools; // quality of schools

    @Min(value = 1, message = "This should be > 1" )
    public int parks;

    @Min(value = 1, message = "This should be > 1" )
    public int hospitals; // quality

    @Min(value = 1, message = "This should be > 1" )
    public int commute; // easy travel

    public Neighbor(){

    }

    public Neighbor(Long id, String place, String neighborhood, int avg_rent, int safety, int nightlife, int schools, int parks, int hospitals, int commute) {
        this.id = id;
        this.place = place;
        Neighborhood = neighborhood;
        this.avg_rent = avg_rent;
        this.safety = safety;
        this.nightlife = nightlife;
        this.schools = schools;
        this.parks = parks;
        this.hospitals = hospitals;
        this.commute = commute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    public int getAvg_rent() {
        return avg_rent;
    }

    public void setAvg_rent(int avg_rent) {
        this.avg_rent = avg_rent;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }

    public int getNightlife() {
        return nightlife;
    }

    public void setNightlife(int nightlife) {
        this.nightlife = nightlife;
    }

    public int getSchools() {
        return schools;
    }

    public void setSchools(int schools) {
        this.schools = schools;
    }

    public int getParks() {
        return parks;
    }

    public void setParks(int parks) {
        this.parks = parks;
    }

    public int getHospitals() {
        return hospitals;
    }

    public void setHospitals(int hospitals) {
        this.hospitals = hospitals;
    }

    public int getCommute() {
        return commute;
    }

    public void setCommute(int commute) {
        this.commute = commute;
    }
}
