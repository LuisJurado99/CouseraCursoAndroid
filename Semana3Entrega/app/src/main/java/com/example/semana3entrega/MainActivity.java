package com.example.semana3entrega;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.semana3entrega.adapter.PageAdapter;
import com.example.semana3entrega.adapter.PerroAdapter;
import com.example.semana3entrega.fragment.PerfilFragment;
import com.example.semana3entrega.fragment.RecyclerView;
import com.example.semana3entrega.pojo.Perro;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> perroNombre = new ArrayList<>();
    private ArrayList<Integer> perroFoto = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        tabLayout= findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopcuones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOpAcerca:
                Intent it = new Intent(this,AboutActivity.class);
                startActivity(it);
                break;
            case R.id.menuOpContacto:
                Intent i = new Intent( this, CorreoActivity.class);
                startActivity(i);
                break;
            case R.id.btnStar:
                Bundle bundle = new Bundle();
                ArrayList<Perro> perroLike = new RecyclerView().getPerroLike();
                obtenerNombreyFoto(perroLike);
                bundle.putStringArrayList(getResources().getString(R.string.llaveNombre),perroNombre);
                bundle.putIntegerArrayList(getResources().getString(R.string.llaveFoto),perroFoto);
                Toast.makeText(this,perroLike.get(0).getNombre(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,MostrarLikes.class);
                intent.putExtras(bundle);
                startActivity(intent);
        }
        return true;
    }
    public void obtenerNombreyFoto(ArrayList<Perro> perros){
        for (Perro like: perros) {
            perroNombre.add(like.getNombre());
            perroFoto.add(like.getFoto());
        }
    }
    public ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerView());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()
                ,agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_tblayout);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);


    }

}