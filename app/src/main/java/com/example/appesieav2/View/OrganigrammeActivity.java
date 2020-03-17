package com.example.appesieav2.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.appesieav2.Controller.Controller;
import com.example.appesieav2.R;
import com.example.appesieav2.Model.Staff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*Ecran de détail de l'organigramme en fonction du pôle, se basant sur activity_main2_layout*/
public class OrganigrammeActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    String key = "myCacheList";
    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_layout);
        Intent myIntent = getIntent(); // gets the previously created intent
        String csvfile = myIntent.getStringExtra("csvfile");

        recyclerView = findViewById(R.id.RecyclerView);
        controller = new Controller(this, getSharedPreferences(key, Context.MODE_PRIVATE),csvfile);
        controller.onCreate();
    }


    //Lecture du fichier .csv et récupération des données
    public List<Staff> data = new ArrayList<>();
    public List<Staff> readData(String csvfile){
        InputStream inputStream = null;
        switch (csvfile){
            case "direction":
                inputStream = getResources().openRawResource(R.raw.direction);
                break;
            case "admissions":
                inputStream = getResources().openRawResource(R.raw.admissions);
                break;
            case "alternance":
                inputStream = getResources().openRawResource(R.raw.apprentissage);
                break;
            case "administration":
                inputStream = getResources().openRawResource(R.raw.administration);
                break;
            case "alumni":
                inputStream = getResources().openRawResource(R.raw.alumni);
                break;
            case "communication":
                inputStream = getResources().openRawResource(R.raw.communication);
                break;
            case "international":
                inputStream = getResources().openRawResource(R.raw.international);
                break;
            case "pedagogie":
                inputStream = getResources().openRawResource(R.raw.pedagogie);
                break;
            case "entreprise":
                inputStream = getResources().openRawResource(R.raw.entreprise);
                break;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(";");
                Staff staff = new Staff();
                staff.setNom(row[0]);
                staff.setPoste(row[1]);
                staff.setImage(row[2]);
                staff.setMail(row[3]);
                staff.setLoc(row[4]);
                data.add(staff);
                Log.d("MyActivity2","Just created "+ staff.toString());
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        return data;
    }

    //Permet d'afficher la recyclerView + données à l'écran
    public void showList(List<Staff> data)
    {
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapter(getApplicationContext(), data);
        recyclerView.setAdapter(adapter);
    }

}
