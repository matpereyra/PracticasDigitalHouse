package com.meli.linktracker.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Post implements Serializable {

    private int userId;
    private int id;
    private String title;
    private String body;
}
