package com.example.semana3entrega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3entrega.R;
import com.example.semana3entrega.pojo.Perro;

import java.util.ArrayList;

public class MiPerroAdapter extends RecyclerView.Adapter<MiPerroAdapter.MiPerroViewHolder> {
    ArrayList<Perro> perro;

    public MiPerroAdapter(ArrayList<Perro> perro) {
        this.perro = perro;
    }


    @NonNull
    @Override
    public MiPerroAdapter.MiPerroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_miperro, parent, false);
        return new MiPerroAdapter.MiPerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiPerroViewHolder miPerroViewHolder, int position) {
        Perro perros = perro.get(position);
        miPerroViewHolder.imageViewPrincipal.setImageResource(perros.getFoto());
        miPerroViewHolder.textViewLike.setText(perros.getRango()+"");
    }


    @Override
    public int getItemCount() {
        return perro.size();
    }

    public class MiPerroViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPrincipal;
        public ImageView imageViewHueso;
        public TextView textViewLike;

        public MiPerroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPrincipal = itemView.findViewById(R.id.imgMiPerroFoto);
            imageViewHueso = itemView.findViewById(R.id.ivHuesoMiName);
            textViewLike = itemView.findViewById(R.id.tvMiPerroLikes);
        }
    }

}
