package com.appform.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView nombre, universidad, documento;
    Button goSicau, camara;

    ImageView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre=(TextView)findViewById(R.id.nametwo);
        universidad=(TextView)findViewById(R.id.universitytwo);
        documento=(TextView) findViewById(R.id.nittwo);
        goSicau=(Button)findViewById(R.id.sicau);
        camara = (Button)findViewById(R.id.btcam);
        visor = (ImageView)findViewById(R.id.vista);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openCam(view);}
        });

        String name = getIntent().getStringExtra("name");
        String lastname = getIntent().getStringExtra("lastname");
        nombre.setText("Nombre: " + name + " " + lastname);
        String nit = getIntent().getStringExtra("nit");
        documento.setText("Documento: " + nit);
        String university = getIntent().getStringExtra("university");
        universidad.setText("Universidad: " + university);

        goSicau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {irSicau(view);}
        });
    }
    public void irSicau(View view){
        Intent sicau = new Intent(Intent.ACTION_VIEW); //Intent is for go to new screen
        sicau.setData(Uri.parse("https://sicau.pascualbravo.edu.co/SICAU/Account/Login"));
        startActivity(sicau);
    }
    public void openCam(View view){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(getPackageManager())!=null){
            startActivityForResult(i, 1);
        }
    }
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == 1 && resultcode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            visor.setImageBitmap(imgBitmap);
        }
    }
}