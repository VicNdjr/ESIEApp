package com.example.appesieav2.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Objectif {
    @SerializedName("obj")
    private String objectif;
    @SerializedName("sit")
    private String situation;

    public Objectif(String objectif, String situation) {
        this.objectif = objectif;
        this.situation = situation;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
