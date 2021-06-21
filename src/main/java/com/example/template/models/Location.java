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
    private UUID id;
    @NotBlank
    private  double Longitude;
    @NotBlank
    private  double Latitude;
    @NotBlank
    private  String LocationName;
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Assets> assets;
}
