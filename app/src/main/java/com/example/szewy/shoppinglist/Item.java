package com.example.szewy.shoppinglist;

import java.io.Serializable;

public class Item implements Serializable {
    String title;
    String description;
    String image;

    public Item(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
