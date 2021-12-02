package com.example.template.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Reviews {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private  Assets assets;
    private  String review;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sent_id", nullable = false)
    private User sentBy;

    public User getSentBy() {
        return sentBy;
    }

    public void setSentBy(User sentBy) {
        this.sentBy = sentBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Reviews() {
    }

}
