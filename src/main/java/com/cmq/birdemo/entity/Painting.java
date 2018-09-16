package com.cmq.birdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xavier.qiu
 * 9/15/18 9:36 PM
 */
@Entity
@Data
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userEmail;
    private String imageUrl;

    private int like;
    private int dislike;

    private String name;

}
