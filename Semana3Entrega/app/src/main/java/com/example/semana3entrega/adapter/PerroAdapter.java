package com.example.semana3entrega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3entrega.R;
import com.example.semana3entrega.pojo.Perro;

import java.util.ArrayList;

public class PerroAdapter extends RecyclerView.Adapter<PerroAdapter.PerroViewHolder> {
    ArrayList<Perro> perro;
    public ArrayList<Perro> perroLike = new ArrayList<>();

    public PerroAdapter(ArrayList<Perro> perros) {
        this.perro = perros;
    }


    @NonNull
    @Override
    public PerroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perro,parent,false);
        return new PerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerroViewHolder perroViewHolder, int position) {
        final Perro perros = perro.get(position);
        perroViewHolder.imageViewPrincipa.setImageResource(perros.getFoto());
        perroViewHolder.textViewName.setText(perros.getNombre());
        perroViewHolder.imageViewHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perroLike.add(new Perro(perros.getNombre(),perros.getRango(),perros.getFoto()));
                Toast.makeText(v.getContext(),perros.getNombre()+perros.getRango()+perros.getFoto(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return perro.size();
    }

    public class PerroViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPrincipa;
        public ImageView imageViewHueso;
        public TextView textViewName;

        public PerroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPrincipa = itemView.findViewById(R.id.imgFotoCV);
            imageViewHueso = itemView.findViewById(R.id.imgHuesoColorCVContacto);
            textViewName = itemView.findViewById(R.id.tvNombreCV);
        }
    }
}
