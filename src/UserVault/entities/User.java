package UserVault.entities;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private Profile profile;


    public User(String username, String password,Profile profile) {
        this.username = username;
        this.password = password;
       this.profile = profile;
    }

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


    @Override
    public String toString() {
        return "👤 " + username;
    }
}
