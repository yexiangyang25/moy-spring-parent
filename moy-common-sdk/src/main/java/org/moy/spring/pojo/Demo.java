package org.moy.spring.pojo;

import java.io.Serializable;

public class Demo implements Serializable {
    private static final long serialVersionUID = -3930058990427525203L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
