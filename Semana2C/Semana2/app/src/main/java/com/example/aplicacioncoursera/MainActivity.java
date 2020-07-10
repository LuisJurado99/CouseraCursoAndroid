package com.example.aplicacioncoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button, buttonIntent;
    TextInputLayout editTextNameL,
            editTextEmailL, editTextDescriptionL, editTextPhoneL;
    EditText editTextDate, editTextName, editTextEmail, editTextDescription, editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextDate = findViewById(R.id.edtDate);
        editTextDate.setVisibility(View.INVISIBLE);

    }

    public void cargarDatos() {
        Bundle bundle = this.getIntent().getExtras();
        if (!bundle.isEmpty()) {
            editTextDate = findViewById(R.id.edtDate);
            editTextNameL = (TextInputLayout) findViewById(R.id.edtName);
            editTextEmailL = (TextInputLayout) findViewById(R.id.edtEmail);
            editTextDescriptionL = (TextInputLayout) findViewById(R.id.edtDescripcion);
            editTextPhoneL = (TextInputLayout) findViewById(R.id.edtPhone);
            editTextEmail = editTextEmailL.getEditText();
            editTextDescription = editTextDescriptionL.getEditText();
            editTextName = editTextNameL.getEditText();
            editTextPhone = editTextPhoneL.getEditText();
            bundle.getString(getResources().getString(R.string.keyPhone));
            editTextName.setText(bundle.getString(getResources().getString(R.string.keyName)));
            editTextDate.setText(bundle.getString(getResources().getString(R.string.keyDate)));
            editTextEmail.setText(bundle.getString(getResources().getString(R.string.keyEmail)));
            editTextDescription.setText(bundle.getString(getResources().getString(R.string.keyDescription)));
            editTextPhone.setText(bundle.getString(getResources().getString(R.string.keyPhone)));
        }


    }


    @Override
    protected void onResume() {
        super.onResume();

        buttonIntent = findViewById(R.id.btnPage);
        button = findViewById(R.id.BtnDate);
        editTextDate = findViewById(R.id.edtDate);
        editTextNameL = (TextInputLayout) findViewById(R.id.edtName);
        editTextEmailL = (TextInputLayout) findViewById(R.id.edtEmail);
        editTextDescriptionL = (TextInputLayout) findViewById(R.id.edtDescripcion);
        editTextPhoneL = (TextInputLayout) findViewById(R.id.edtPhone);
        editTextEmail = editTextEmailL.getEditText();
        editTextDescription = editTextDescriptionL.getEditText();
        editTextName = editTextNameL.getEditText();
        editTextPhone = editTextPhoneL.getEditText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    public void message(View view) {
        String strName, strDate, strDescription, strPhone, strEmail;
        Intent i = new Intent(this, MostrarDatos.class);
        AlertDialog alertDialog;
        AlertDialog.Builder aBuilder;
        aBuilder = new AlertDialog.Builder(this);
        strName = editTextName.getText().toString();
        strEmail = editTextEmail.getText().toString();
        strPhone = editTextPhone.getText().toString();
        strDescription = editTextDescription.getText().toString();
        strDate = editTextDate.getText().toString();
        if (strName.isEmpty() || strDate.isEmpty() || strDescription.isEmpty() || strPhone.isEmpty() || strEmail.isEmpty()) {
            aBuilder.setTitle(getResources().getString(R.string.faltan_datos));
            aBuilder.setMessage("Faltan datos en el sistema");
            aBuilder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            aBuilder.create();
            aBuilder.show();

        } else {
            Bundle bundle = new Bundle();
            bundle.putString(getResources().getString(R.string.keyName), editTextName.getText().toString());
            bundle.putString(getResources().getString(R.string.keyEmail), editTextEmail.getText().toString());
            bundle.putString(getResources().getString(R.string.keyPhone), editTextPhone.getText().toString());
            bundle.putString(getResources().getString(R.string.keyDescription), editTextDescription.getText().toString());
            bundle.putString(getResources().getString(R.string.keyDate), editTextDate.getText().toString());
            i.putExtras(bundle);
            startActivity(i);

        }

    }

    private void showDatePickerDialog() {
        editTextDate = findViewById(R.id.edtDate);
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month + 1) + " / " + year;
                editTextDate.setVisibility(View.VISIBLE);
                editTextDate.setText(selectedDate);
            }

        });


        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

}