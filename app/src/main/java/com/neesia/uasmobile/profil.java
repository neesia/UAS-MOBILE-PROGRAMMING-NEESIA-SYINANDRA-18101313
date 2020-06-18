package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class profil extends AppCompatActivity {
    TextView textuser;
    uasmobile sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sp = new uasmobile();
        textuser = (TextView) findViewById(R.id.txtusername);
        String username;
        username = sp.getValue(context, "username");

        textuser.setText(username);
    }
}
