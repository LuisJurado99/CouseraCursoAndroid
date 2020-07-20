package com.example.semana3entrega;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3entrega.adapter.PerroAdapter;
import com.example.semana3entrega.pojo.Perro;

import java.util.ArrayList;

public class MostrarLikes extends AppCompatActivity {
    ArrayList<Perro> perros = new ArrayList<Perro>();
    RecyclerView listaPerros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes_mostrar);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle.isEmpty()) {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_LONG).show();
        } else {
            ArrayList<String> arrayListNombre = bundle.getStringArrayList(getResources()
                    .getString(R.string.llaveNombre));
            ArrayList<Integer> arrayListFoto = bundle.getIntegerArrayList(getResources()
                    .getString(R.string.llaveFoto));
            int i = 0;

            Toast.makeText(this,arrayListNombre.get(1),Toast.LENGTH_LONG).show();
            while (arrayListFoto.size() > i) {
                perros.add(new Perro(arrayListNombre.get(i), 0, arrayListFoto.get(i)));
                i++;
            }
            listaPerros = findViewById(R.id.rvLikesMostrarBase);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            listaPerros.setLayoutManager(llm);
            PerroAdapter perroAdaptador = new PerroAdapter(perros);
            listaPerros.setAdapter(perroAdaptador);
        }
    }
}