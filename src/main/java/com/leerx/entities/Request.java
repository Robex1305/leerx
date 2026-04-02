package com.leerx.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "REQUEST")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String method;

    public String url;

    public String content;

    public Instant creationTime;


}

