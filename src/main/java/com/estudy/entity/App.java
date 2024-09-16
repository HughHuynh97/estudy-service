package com.estudy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app")
public class App extends BaseEntity {
    @Id
    @Column(name = "app_id")
    private Long appId;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "keywords")
    private String keywords;

}
