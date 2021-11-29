package com.example.template.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @NotBlank
    private  double Longitude;
    @NotBlank
    private  double Latitude;
    @NotBlank
    private  String LocationName;

    public Location(@NotBlank double longitude, @NotBlank double latitude, @NotBlank String locationName) {
        Longitude = longitude;
        Latitude = latitude;
        LocationName = locationName;
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
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public Set<Assets> getAssets() {
        return assets;
    }

    public void setAssets(Set<Assets> assets) {
        this.assets = assets;
    }
}
