package com.example.template.models;

import com.example.template.enums.EAssetType;
import com.example.template.enums.EStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private EAssetType type;
    private Location location;
    private Date  date_created;
    private EStatus status;

    public Assets() {
    }

    public Assets(User user, EAssetType type, Location location, Date date_created, EStatus status) {
        this.user = user;
        this.type = type;
        this.location = location;
        this.date_created = date_created;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
