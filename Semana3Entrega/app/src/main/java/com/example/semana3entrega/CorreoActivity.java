package com.example.semana3entrega;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class CorreoActivity extends AppCompatActivity {
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutSubject;
    TextInputLayout textInputLayoutMessage;
    EditText editTextEmail;
    EditText editTextSubject;
    EditText editTextMessage;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);
        textInputLayoutEmail = findViewById(R.id.tilACCorreo);
        textInputLayoutSubject = findViewById(R.id.tilACSubject);
        textInputLayoutMessage = findViewById(R.id.tilACMessage);
        editTextEmail = textInputLayoutEmail.getEditText();
        editTextSubject = textInputLayoutSubject.getEditText();
        editTextMessage = textInputLayoutMessage.getEditText();

        button = findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMail();
            }
        });
    }

    public void SendMail() {
        String enviarcorreo = editTextEmail.getText().toString();
        String enviarasunto = editTextSubject.getText().toString();
        String enviarmensaje = editTextMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);

        // Defino los Strings Email, Asunto y Mensaje con la función putExtra
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{enviarcorreo});
        intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
        intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

        // Establezco el tipo de Intent
        intent.setType("message/rfc822");

        // Lanzo el selector de cliente de Correo
        startActivity(
                Intent.createChooser(intent, "Elije un cliente de Correo:"));


    }
}