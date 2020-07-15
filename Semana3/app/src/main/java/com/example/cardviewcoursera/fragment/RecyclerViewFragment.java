package com.example.cardviewcoursera.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardviewcoursera.R;
import com.example.cardviewcoursera.adapter.PerroAdaptador;
import com.example.cardviewcoursera.pojo.Perro;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Perro> perros;
    public PerroAdaptador adaptador;
    private RecyclerView rvPerros;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        rvPerros = v.findViewById(R.id.rvBaseFragment);
        LinearLayoutManager llm =new  LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerros.setLayoutManager(llm);
        inicializarDatos();
        inicializarAdaptador();
        return v;
    }

    public void inicializarDatos() {
        perros = new ArrayList<>();
        perros.add(new Perro("Luis Jurado", 10, R.drawable.perro));
        perros.add(new Perro("Ceci Jurado", 6, R.drawable.perro2));
        perros.add(new Perro("Miguel Jurado", 7, R.drawable.perro3));
        perros.add(new Perro("Laura Negrete", 8, R.drawable.perro4));
        perros.add(new Perro("Miguel Jurado P", 9, R.drawable.perro5));
    }

    ;

    public void inicializarAdaptador() {
        adaptador = new PerroAdaptador(perros);
        rvPerros.setAdapter(adaptador);
    }
}