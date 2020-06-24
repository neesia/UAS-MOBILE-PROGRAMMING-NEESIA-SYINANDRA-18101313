package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    Button btnprofil, btnkeluar, btndatabuku, btndatafilm ;
    uasmobile sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnprofil = (Button) findViewById(R.id.btnprofil);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btndatabuku = (Button) findViewById(R.id.btndatabuku);
        btndatafilm = (Button) findViewById(R.id.btndatafilm);
        sp = new uasmobile();


        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent inten = new Intent(menu.this,MainActivity.class);
                startActivity(inten);
            }
        });

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(menu.this,profil.class);
                startActivity(inten);
            }
        });

        btndatabuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(menu.this, databuku.class);
                startActivity(inten);
            }
        });

        btndatafilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(menu.this, datafilm.class);
                startActivity(inten);
            }
        });


    }
}
