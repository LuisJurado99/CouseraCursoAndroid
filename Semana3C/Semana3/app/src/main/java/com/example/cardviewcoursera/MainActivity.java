package com.example.cardviewcoursera;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Perro> perros = new ArrayList<Perro>();

    RecyclerView listaContactos;
    ArrayList<String> nombrePerro = new ArrayList<String>();
    ArrayList<Integer> rangoPerro = new ArrayList<Integer>();
    ArrayList<Integer> fotoPerro = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miAToolbar = (Toolbar) findViewById(R.id.acBar);
        setSupportActionBar(miAToolbar);
        ArrayList<Perro> perrosLike = new ArrayList<Perro>();
        listaContactos = (RecyclerView) findViewById(R.id.rvMainBase);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaContactos.setLayoutManager(llm);
        perros.add(new Perro("Luis Jurado", 10, R.drawable.perro));
        perros.add(new Perro("Ceci Jurado", 6, R.drawable.perro2));
        perros.add(new Perro("Miguel Jurado", 7, R.drawable.perro3));
        perros.add(new Perro("Laura Negrete", 8, R.drawable.perro4));
        perros.add(new Perro("Miguel Jurado P", 9, R.drawable.perro5));
        PerroAdaptador perroAdaptador = new PerroAdaptador(perros);
        listaContactos.setAdapter(perroAdaptador);
        perrosLike = perroAdaptador.perroLike;
        ImageButton imageButton = findViewById(R.id.imgbIntent);
        final ArrayList<Perro> finalPerrosLike = perrosLike;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                cargarDatos(finalPerrosLike);
                bundle.putStringArrayList(getResources().getString(R.string.keyStringArrayMainMostrarNombre), nombrePerro);
                bundle.putIntegerArrayList(getResources().getString(R.string.keyStringArrayMainMostrarRango), rangoPerro);
                bundle.putIntegerArrayList(getResources().getString(R.string.keyStringArrayMainMostrarFoto), fotoPerro);
                Intent intent = new Intent(getApplicationContext(), MostrarLikes.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public void cargarDatos(ArrayList<Perro> perrosLike) {
        for (Perro perro : perrosLike) {
            nombrePerro.add(perro.getNombre());
            rangoPerro.add(perro.getRango());
            fotoPerro.add(perro.getFoto());
        }

    }


}