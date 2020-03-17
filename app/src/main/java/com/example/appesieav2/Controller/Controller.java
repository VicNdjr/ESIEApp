package com.example.appesieav2.Controller;

import android.content.SharedPreferences;

import com.example.appesieav2.View.OrganigrammeActivity;
import com.example.appesieav2.Model.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/*Chargement de la data dans mainActivity2*/
public class Controller {

    private final OrganigrammeActivity mainactivity;
    private SharedPreferences sharedPreferences;
    private static Controller controller = null;
    private String csvfile;


    public Controller(OrganigrammeActivity mainActivity, SharedPreferences sharedPreferences, String csvfile){
        this.mainactivity = mainActivity;
        this.sharedPreferences = sharedPreferences;
        this.csvfile = csvfile;
    }

    public static Controller getActivity(OrganigrammeActivity mainactivity, SharedPreferences sharedPreferences, String csvfile){
        if(controller==null){
            controller = new Controller(mainactivity, sharedPreferences, csvfile);
        }
        return controller;
    }



    /*AMELIORATIONS : gestion du cache à implémenter correctement*/
    public void onCreate(){
        if(sharedPreferences.contains("myCacheList")) {
            List<Staff> data = mainactivity.readData(csvfile);
            /*
            String myCache = sharedPreferences.getString("myCacheList", "no data found");
            Type type = new TypeToken<List<Staff>>() {
            }.getType();*/
            mainactivity.showList(data);

        }else{
            List<Staff> data = mainactivity.readData(csvfile);

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            String myCache = gson.toJson(data);

            sharedPreferences.edit()
                    .putString("myCacheList", myCache)
                    .apply();

            mainactivity.showList(data);
        }
    }

}
