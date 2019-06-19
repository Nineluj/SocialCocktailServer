package com.boost.SocialCocktailJavaServer.models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;

@Entity
public class Bartender extends User {
    @JsonView(JacksonView.freeContext.class)
    private boolean verified;

    private String barName;
    private String supervisorName;
    private String supervisorTelephone;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorTelephone() {
        return supervisorTelephone;
    }

    public void setSupervisorTelephone(String supervisorTelephone) {
        this.supervisorTelephone = supervisorTelephone;
    }
}
