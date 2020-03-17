package com.example.appesieav2.Network;

import com.example.appesieav2.Model.Annee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/VectoorSK/ESIEA_API/master/cursus0.json")
    Call<List<Annee>> getAllYears();
}
