package org.aplewa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {
    public Owner() {
    }

    @JsonProperty("login")
    private String login;


    //getters setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
