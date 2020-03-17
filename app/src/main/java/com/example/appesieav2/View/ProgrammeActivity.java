package com.example.appesieav2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appesieav2.R;
import com.example.appesieav2.Model.Annee;
import com.example.appesieav2.Model.Bloc;
import com.example.appesieav2.Model.Matiere;
import com.example.appesieav2.Model.Objectif;
import com.example.appesieav2.Network.GetDataService;
import com.example.appesieav2.Network.RetrofitClientInstance;
import com.jakewharton.picasso.OkHttp3Downloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.cardview.widget.CardView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgrammeActivity extends AppCompatActivity {

    private List<Annee> datalist;
    ProgressDialog progressDialog;
    private int filter = 0;
    private int year = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programme_fragment);

        loadCursus();
    }

    private void loadCursus() {
        progressDialog = new ProgressDialog(ProgrammeActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        final GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Annee>> call = service.getAllYears();
        call.enqueue(new Callback<List<Annee>>() {
            @Override
            public void onResponse(Call<List<Annee>> call, Response<List<Annee>> response) {
                progressDialog.dismiss();
                datalist = response.body();
                showCursus(datalist.get(0));
            }

            @Override
            public void onFailure(Call<List<Annee>> call, Throwable t) {
                System.out.println(call);
                System.out.println(t);
                progressDialog.dismiss();
                Toast.makeText(ProgrammeActivity.this, "Something went wrong... Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showCursus (final Annee annee) {
        for (int j = 1; j <= 5 ; j++) {
            int btnID = getResources().getIdentifier("btn_" + j + "a", "id", getPackageName());
            CardView btn = (CardView) findViewById(btnID);
            btn.setCardBackgroundColor(0xFF0085C6);
            ((TextView)((ViewGroup) btn).getChildAt(0)).setTextColor(0xFFFFFFFF);
        }
        int btnID = getResources().getIdentifier("btn_" + annee.getAnnee() + "a", "id", getPackageName());
        CardView btn = (CardView) findViewById(btnID);
        btn.setCardBackgroundColor(0xFFFFFFFF);
        ((TextView)((ViewGroup) btn).getChildAt(0)).setTextColor(0xFF0085C6);

        int idTitle = getResources().getIdentifier("title_1a", "id", getPackageName());
        TextView title = (TextView) findViewById(idTitle);
        if (annee.getAnnee() == 1) {
            title.setText("1ère Année");
        } else {
            title.setText(annee.getAnnee() + "ème Année");
        }

        int containerID = getResources().getIdentifier("card_1a", "id", getPackageName());
        ViewGroup container = (ViewGroup) findViewById(containerID);

        for (int j = container.getChildCount()-1; j > 0; j--) {
            container.removeViewAt(j);
        }
        if (filter == 2 && annee.getAnnee() == 5) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
            final View view = layoutInflater.inflate(R.layout.bloc_layout, null);
            TextView layout = (TextView) view.findViewById(R.id.bloc_titre);
            layout.setText("Stage de fin d'étude");

            container.addView(view);
        } else {
            int i = 0;
            for (final Bloc bloc : annee.getBlocs()) {
                i++;
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
                final View view = layoutInflater.inflate(R.layout.bloc_layout, null);
                TextView layout = (TextView) view.findViewById(R.id.bloc_titre);
                layout.setText(bloc.getNom());

                container.addView(view, i, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                for (final Matiere matiere : bloc.getMatieres()) {
                    if (filter == 0 || (filter == 1 && matiere.getSemestre() == 1) || (filter == 2 && matiere.getSemestre() == 2)) {
                        LayoutInflater layoutInflater2 = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
                        View view2 = layoutInflater2.inflate(R.layout.matiere_layout, null);
                        view2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent viewIntent = new Intent(ProgrammeActivity.this, MatiereActivity.class);
                                viewIntent.putExtra("annee", annee.getAnnee());
                                viewIntent.putExtra("bloc", bloc.getNom());
                                viewIntent.putExtra("nom", matiere.getNom());
                                viewIntent.putExtra("semestre", matiere.getSemestre());
                                startActivity(viewIntent);
                            }
                        });

                        if (matiere.getSemestre() == 1) {
                            view2.setBackgroundColor(0xffffffff);
                        } else if (matiere.getSemestre() == 2) {
                            view2.setBackgroundColor(0xffdddddd);
                        }

                        TextView name = (TextView) view2.findViewById(R.id.titleM);
                        name.setText("• " + matiere.getNom());
                        TextView coeff = (TextView) view2.findViewById(R.id.coeffM);
                        if (matiere.getCoeff() == Math.floor(matiere.getCoeff())) {
                            coeff.setText(String.format("%.0f", matiere.getCoeff()));
                        } else {
                            coeff.setText(Double.toString(matiere.getCoeff()));
                        }
                        ((ViewGroup) ((ViewGroup) ((ViewGroup) container.getChildAt(i)).getChildAt(0)).getChildAt(0)).addView(view2, -1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    }
                }
            }
        }
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    public void loadYear1(View view) {
        showCursus(datalist.get(0));
        year = 1;
    }
    public void loadYear2(View view) {
        showCursus(datalist.get(1));
        year = 2;
    }
    public void loadYear3(View view) {
        showCursus(datalist.get(2));
        year = 3;
    }
    public void loadYear4(View view) {
        showCursus(datalist.get(3));
        year = 4;
    }
    public void loadYear5(View view) {
        showCursus(datalist.get(4));
        year = 5;
    }

    public void showAllSemester (View view) {
        filter = 0;
        showCursus(datalist.get(year-1));
    }
    public void showSemester1 (View view) {
        filter = 1;
        showCursus(datalist.get(year-1));
    }
    public void showSemester2 (View view) {
        filter = 2;
        showCursus(datalist.get(year-1));
    }


}
