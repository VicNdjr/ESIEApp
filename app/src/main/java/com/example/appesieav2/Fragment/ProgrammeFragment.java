package com.example.appesieav2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appesieav2.R;
import com.example.appesieav2.View.ProgrammeActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class ProgrammeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.programme_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CardView button1a = getActivity().findViewById(R.id.btn_1a);
        CardView button2a = getActivity().findViewById(R.id.btn_2a);
        CardView button3a = getActivity().findViewById(R.id.btn_3a);
        CardView button4a = getActivity().findViewById(R.id.btn_4a);
        CardView button5a = getActivity().findViewById(R.id.btn_5a);

        button1a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProgrammeActivity.class);
                myIntent.putExtra("annee", "1");
                startActivity(myIntent);
            }
        });
        button2a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProgrammeActivity.class);
                myIntent.putExtra("annee", "2");
                startActivity(myIntent);
            }
        });
        button3a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProgrammeActivity.class);
                myIntent.putExtra("annee", "3");
                startActivity(myIntent);
            }
        });
        button4a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProgrammeActivity.class);
                myIntent.putExtra("annee", "4");
                startActivity(myIntent);
            }
        });
        button5a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProgrammeActivity.class);
                myIntent.putExtra("annee", "5");
                startActivity(myIntent);
            }
        });
    }


}
