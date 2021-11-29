package com.example.template.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @NotNull
    private  double longitude;
    @NotNull
    private  double latitude;
    @NotBlank
    private  String locationName;

    public Location(@NotNull double longitude, @NotNull double latitude, @NotBlank String locationName) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = locationName;
    }

    public Location() {
    }

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Assets> assets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
       this.longitude= longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Assets> getAssets() {
        return assets;
    }

    public void setAssets(Set<Assets> assets) {
        this.assets = assets;
    }
}
