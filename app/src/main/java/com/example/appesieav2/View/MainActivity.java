package com.example.appesieav2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appesieav2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bouton = findViewById(R.id.connect_button);
        final EditText adresseEmailESIEA = findViewById(R.id.adresse_email_ESIEA);
        final EditText motDePasse = findViewById(R.id.mot_de_passe);

        final Intent intent = new Intent(this, HomeActivity.class);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adresseEmailESIEA_val = adresseEmailESIEA.getText().toString();
                String motDePasse_val = motDePasse.getText().toString();

                /* il faudra ici faire appel à la base de données comportant toutes les adresses emails et mot de passes des étudiants de l'ESIEA */

                if (adresseEmailESIEA_val.equals("test@et.esiea.fr") && (motDePasse_val.equals("test"))){
                    startActivity(intent);
                }
            }
        });

    }
}
