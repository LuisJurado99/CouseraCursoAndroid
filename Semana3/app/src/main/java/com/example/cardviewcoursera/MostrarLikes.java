package com.example.cardviewcoursera;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardviewcoursera.adapter.PerroAdaptador;
import com.example.cardviewcoursera.pojo.Perro;

import java.util.ArrayList;

public class MostrarLikes extends AppCompatActivity {
    ArrayList<Perro> perros = new ArrayList<Perro>();
    RecyclerView listaPerros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int i = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.likes_mostrar);


        Bundle bundle = this.getIntent().getExtras();
        if (bundle.isEmpty()) {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_LONG);
        } else {
            ArrayList<String> arrayListNombre = bundle.getStringArrayList(getResources()
                    .getString(R.string.keyStringArrayMainMostrarNombre));
            ArrayList<Integer> arrayListFoto = bundle.getIntegerArrayList(getResources()
                    .getString(R.string.keyStringArrayMainMostrarFoto));
            ArrayList<Integer> arrayListRango = bundle.getIntegerArrayList(getResources()
                    .getString(R.string.keyStringArrayMainMostrarRango));

            while (arrayListFoto.size() > i) {
                perros.add(new Perro(arrayListNombre.get(i), arrayListRango.get(i), arrayListFoto.get(i)));
                i++;
            }
            listaPerros = findViewById(R.id.rvLikesMostrarBase);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            listaPerros.setLayoutManager(llm);
            PerroAdaptador perroAdaptador = new PerroAdaptador(perros);
            listaPerros.setAdapter(perroAdaptador);


        }
    }
}