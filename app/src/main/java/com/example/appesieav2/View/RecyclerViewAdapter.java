package com.example.appesieav2.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appesieav2.R;
import com.example.appesieav2.Model.Staff;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/*Chargement des données dans les champs de l'organigramme*/
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    public List<Staff> data;

    //on récupère les éléments dans lesquels on va charger des données
    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ImageAcceuil;
        TextView textImage;
        TextView textPoste;
        TextView textMail;
        TextView textLoc;
        public ViewHolder(View itemView) {
            super(itemView);
            ImageAcceuil = itemView.findViewById(R.id.ImageAcceuil);
            textImage = itemView.findViewById(R.id.textName);
            textPoste = itemView.findViewById(R.id.textPoste);
            textMail = itemView.findViewById(R.id.textMail);
            textLoc = itemView.findViewById(R.id.textLoc);
        }
    }

    //Constructeur
    public RecyclerViewAdapter(Context context, List<Staff> data) {
        this.context = context;
        this.data = data;
    }

    //on utilise item_layout comme modèle
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    //on recupere l'index avec position et on affiche les textes et l'image correspondant à l'item
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Staff listItem = data.get(position);

        Picasso.get().load(listItem.getImage()).into(holder.ImageAcceuil); //affiche l'image (via url)
        holder.textImage.setText(listItem.getNom());
        holder.textPoste.setText(listItem.getPoste());
        if(listItem.getMail().equals("mail")){ //cas mail inconnu
            holder.textMail.setText("");
        }else{
            holder.textMail.setText(listItem.getMail());
        }
        if(listItem.getLoc().equals("(-)")){ //cas localisation inconnue
            holder.textLoc.setText("");
        }else{
            holder.textLoc.setText(listItem.getLoc());
        }

    }

    @Override //On retourne le nombre d'élement à afficher
    public int getItemCount() {
        return data.size();
    }


}
