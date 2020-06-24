package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class profil extends AppCompatActivity {
    TextView textuser;
    uasmobile sp;
    Activity context = this;
    Menu menu;
    ImageButton btnkeluarprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sp = new uasmobile();
        textuser = (TextView) findViewById(R.id.txtusername);
        String username;
        username = sp.getValue(context, "username");
        btnkeluarprofil = (ImageButton) findViewById(R.id.btnkeluarprofil);

        textuser.setText(username);

        btnkeluarprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(profil.this,menu.class);
                startActivity(inten);
            }
        });
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.menu = menu;
        menu.add(0,1,0,"Exit");
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                finish();
                return true;
        }
        return false;
    }


}
