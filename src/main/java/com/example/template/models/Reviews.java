package com.example.template.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Reviews {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private  Assets assets;
    private  String review;
}
