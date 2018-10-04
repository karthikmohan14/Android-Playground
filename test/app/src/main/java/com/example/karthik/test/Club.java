package com.example.karthik.test;

public class Club {
    private int image;
    private String title, desc;

    public Club() {
    }

    public Club(int image,String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
