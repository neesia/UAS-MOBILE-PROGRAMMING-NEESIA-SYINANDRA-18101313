package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    Button btnprofil, btnkeluar, btndatabuku;
    uasmobile sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnprofil = (Button) findViewById(R.id.btnprofil);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btndatabuku = (Button) findViewById(R.id.btndatabuku);
        sp = new uasmobile();

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(menu.this, profil.class);
                startActivity(inten);
            }
        });

        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.clearuasmobile(context);
                finish();
            }
        });

        btndatabuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(menu.this, databuku.class);
                startActivity(inten);
            }
        });

    }
}
