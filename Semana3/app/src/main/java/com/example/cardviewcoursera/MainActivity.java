package com.example.cardviewcoursera;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.cardviewcoursera.adapter.PageAdapter;
import com.example.cardviewcoursera.fragment.PerfilFragment;
import com.example.cardviewcoursera.fragment.RecyclerViewFragment;
import com.example.cardviewcoursera.pojo.Perro;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Perro> perros = new ArrayList<Perro>();

    RecyclerView listaContactos;
    ArrayList<String> nombrePerro = new ArrayList<String>();
    ArrayList<Integer> rangoPerro = new ArrayList<Integer>();
    ArrayList<Integer> fotoPerro = new ArrayList<Integer>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

        /*ArrayList<Perro> perrosLike = new ArrayList<Perro>();
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
        */

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);


    }
    public void cargarDatos(ArrayList<Perro> perrosLike) {
        for (Perro perro : perrosLike) {
            nombrePerro.add(perro.getNombre());
            rangoPerro.add(perro.getRango());
            fotoPerro.add(perro.getFoto());
        }

    }


}