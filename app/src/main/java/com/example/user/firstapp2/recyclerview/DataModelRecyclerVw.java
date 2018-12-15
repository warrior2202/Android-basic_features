package com.example.user.firstapp2.recyclerview;

public class DataModelRecyclerVw {
    String name;
    String version;
    int id_;
    int image;

    public DataModelRecyclerVw(String name, String version, int id_, int image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}


