package com.example.semana3entrega.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.semana3entrega.R;
import com.example.semana3entrega.adapter.MiPerroAdapter;
import com.example.semana3entrega.pojo.Perro;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private ArrayList<Perro> perros = new ArrayList<>();

    private androidx.recyclerview.widget.RecyclerView rvPerros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvPerros = v.findViewById(R.id.rvMiPerro);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        llenarDatos();
        rvPerros.setAdapter(new MiPerroAdapter(perros));
        rvPerros.setLayoutManager(glm);
        return v;
    }

    public void llenarDatos() {
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));
        perros.add(new Perro("Panfilo",getRandom(5,20),R.drawable.perro5));

    }

    public static int getRandom(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }
}