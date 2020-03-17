package com.example.appesieav2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.appesieav2.View.OrganigrammeActivity;
import com.example.appesieav2.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrganigrammeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_orga_layout,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button direction = (Button) getActivity().findViewById(R.id.Direction);
        Button admissions = (Button) getActivity().findViewById(R.id.Admission);
        Button alternance = (Button) getActivity().findViewById(R.id.Alternance);
        Button administration = (Button) getActivity().findViewById(R.id.Administration);
        Button alumni = (Button) getActivity().findViewById(R.id.ALUMNI);
        Button communication = (Button) getActivity().findViewById(R.id.Communication);
        Button international = (Button) getActivity().findViewById(R.id.International);
        Button pedagogie = (Button) getActivity().findViewById(R.id.Pédagogie);
        Button entreprise = (Button) getActivity().findViewById(R.id.Entreprise);

        //chargement du fichier .cvs correspondant au pôle cliqué
        direction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "direction");
                startActivity(myIntent);
            }
        });
        admissions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "admissions");
                startActivity(myIntent);
            }
        });
        alternance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "alternance");
                startActivity(myIntent);
            }
        });
        administration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "administration");
                startActivity(myIntent);
            }
        });
        alumni.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "alumni");
                startActivity(myIntent);
            }
        });
        communication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "communication");
                startActivity(myIntent);
            }
        });
        international.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "international");
                startActivity(myIntent);
            }
        });
        pedagogie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "pedagogie");
                startActivity(myIntent);
            }
        });
        entreprise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), OrganigrammeActivity.class);
                myIntent.putExtra("csvfile", "entreprise");
                startActivity(myIntent);
            }
        });

    }
}
