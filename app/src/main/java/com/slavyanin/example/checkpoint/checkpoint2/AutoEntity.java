package com.slavyanin.example.checkpoint.checkpoint2;

public class AutoEntity {

    private int imageId;
    private String name;

    public AutoEntity(int imageId, String name, String number) {
        this.imageId = imageId;
        this.name = name;
        this.number = number;
    }

    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
