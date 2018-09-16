package com.cmq.birdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xavier.qiu
 * 9/15/18 9:41 PM
 */
@Data
@Entity
public class IpLike {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ipAddress;
    private boolean like;
}
