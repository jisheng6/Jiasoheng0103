package com.bawei.jiasoheng0103;

/**
 * Created by Adminjs on 2018/1/3.
 */

public class UserEvent {
    private String username;
    private String passwork;

    public UserEvent(String username, String passwork) {
        this.username = username;
        this.passwork = passwork;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public UserEvent() {
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "username='" + username + '\'' +
                ", passwork='" + passwork + '\'' +
                '}';
    }
}
