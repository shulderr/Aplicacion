package com.appform.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText nombre, apellido, correo, documento, universidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave=(Button)findViewById(R.id.save);
        nombre=(EditText)findViewById(R.id.name);
        apellido=(EditText)findViewById(R.id.lastname);
        correo=(EditText)findViewById(R.id.mail);
        documento=(EditText)findViewById(R.id.nit);
        universidad=(EditText)findViewById(R.id.university);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()==true){
                    viewDos(view);
                }
            }
        });
    }

    public void viewDos(View view){

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("name", nombre.getText().toString());
        i.putExtra("lastname", apellido.getText().toString());
        i.putExtra("nit", documento.getText().toString());
        i.putExtra("university", universidad.getText().toString());
        startActivity(i);
    }

    public boolean validacion(){
        boolean condicion;

        String name = nombre.getText().toString();
        String lastname = apellido.getText().toString();
        String mail = correo.getText().toString();
        String nit = documento.getText().toString();
        String university = universidad.getText().toString();
        if (name.length() == 0 | lastname.length() == 0 | mail.length() == 0 | nit.length() == 0 | university.length() == 0){
            if (name.isEmpty()){
                nombre.setError("Este Campo Es Obligatorio");
            }
            if (lastname.isEmpty()){
                apellido.setError("Este Campo Es Obligatorio");
            }
            if (mail.isEmpty()){
                correo.setError("Este Campo Es Obligatorio");
            }
            if (nit.isEmpty()){
                documento.setError("Este Campo Es Obligatorio");
            }
            if (university.isEmpty()){
                universidad.setError("Este Campo Es Obligatorio");
            }
            condicion = false;
        }
        else
        {
           condicion = true;
        }
        return condicion;
    }
}