package com.example.user.firstapp2.Retrofitwithgirdandrect;
public class BWceleb {
    private String id;
    private String name;
    private String profile_pic;
    public BWceleb(String id, String name, String profile_pic) {
        this.id = id;
        this.name = name;
        this.profile_pic = profile_pic;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProfile_pic() {
        return profile_pic;
    }
    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
}
