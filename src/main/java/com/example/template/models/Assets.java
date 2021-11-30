package com.example.template.models;

import com.example.template.enums.EAssetType;
import com.example.template.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "assets")
public class Assets {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;
    private EAssetType type;
    private String name;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Location location;
    private Date  date_created;
    private EStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "assets", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Reviews> reviews;

    public Assets(User owner,String name ,EAssetType type, Location location, Date date_created, EStatus status) {
        this.owner = owner;
        this.type = type;
        this.location = location;
        this.date_created = date_created;
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Assets() {
    }

    public EAssetType getType() {
        return type;
    }

    public void setType(EAssetType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Reviews> reviews) {
        this.reviews = reviews;
    }
}