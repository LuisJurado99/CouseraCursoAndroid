package com.example.semana3entrega.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.semana3entrega.R;
import com.example.semana3entrega.adapter.PerroAdapter;
import com.example.semana3entrega.pojo.Perro;

import java.util.ArrayList;


public class RecyclerView extends Fragment {
    private ArrayList<Perro> perros = new ArrayList<>();
    private static ArrayList<Perro> perroLikes = new ArrayList<>();

    private androidx.recyclerview.widget.RecyclerView rvPerros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        // Inflate the layout for this fragment
        rvPerros = v.findViewById(R.id.rvBaseFragment);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerros.setLayoutManager(llm);
        llenarDatos();
        PerroAdapter adapter = new PerroAdapter(perros);
        perroLikes= adapter.perroLike;
        rvPerros.setAdapter(adapter);
        return v;
    }
    public ArrayList<Perro> getPerroLike(){
        return perroLikes;
    }

    public void llenarDatos() {
        perros.add(new Perro("Poppy", 3, R.drawable.perro));
        perros.add(new Perro("Catty", 3, R.drawable.perro2));
        perros.add(new Perro("Woffy", 3, R.drawable.perro3));
        perros.add(new Perro("Max", 3, R.drawable.perro4));
    }
}