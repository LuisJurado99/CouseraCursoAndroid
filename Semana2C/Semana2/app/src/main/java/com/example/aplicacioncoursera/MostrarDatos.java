package com.example.aplicacioncoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarDatos extends AppCompatActivity {
    String strName, strDate, strDescription,strPhone, strEmail;
    TextView txtDate, txtName, txtDescription, txtEmail, txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_mostrar);
        txtDate        = findViewById(R.id.tvDateInsert);
        txtName        = findViewById(R.id.tvNameInsert);
        txtDescription = findViewById(R.id.tvDescriptionInsert);
        txtEmail       = findViewById(R.id.tvEmailInsert);
        txtPhone       = findViewById(R.id.tvPhoneInsert);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle.isEmpty()){
            Toast.makeText(this,"No hay valores",Toast.LENGTH_SHORT).show();

        }else {
            strName        = bundle.getString(getResources().getString(R.string.keyName));
            strDate        = bundle.getString(getResources().getString(R.string.keyDate));
            strEmail       = bundle.getString(getResources().getString(R.string.keyEmail));
            strDescription = bundle.getString(getResources().getString(R.string.keyDescription));
            strPhone       = bundle.getString(getResources().getString(R.string.keyPhone));
            txtName.setText(strName);
            txtDate.setText(strDate);
            txtEmail.setText(strEmail);
            txtDescription.setText(strDescription);
            txtPhone.setText(strPhone);
        }

    }
    public void regreso(View v){
        /*txtDate        = findViewById(R.id.tvDateInsert);
        txtName        = findViewById(R.id.tvNameInsert);
        txtDescription = findViewById(R.id.tvDescriptionInsert);
        txtEmail       = findViewById(R.id.tvEmailInsert);
        txtPhone       = findViewById(R.id.tvPhoneInsert);
        Intent i = new Intent(this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(getResources().getString(R.string.keyName), txtName.getText().toString());
        bundle.putString(getResources().getString(R.string.keyEmail), txtEmail.getText().toString());
        bundle.putString(getResources().getString(R.string.keyPhone), txtPhone.getText().toString());
        bundle.putString(getResources().getString(R.string.keyDescription), txtDescription.getText().toString());
        bundle.putString(getResources().getString(R.string.keyDate), txtDate.getText().toString());
        i.putExtras(bundle);
        startActivity(i);
        */
        onBackPressed();
    }

}