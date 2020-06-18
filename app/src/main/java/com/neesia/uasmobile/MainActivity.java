package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtusername, txtpassword;
    Button btnsubmit;
    private uasmobile sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new uasmobile();
        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtusername.getText().toString();

                if(username.equals("")){
                    Toast.makeText(getBaseContext(), "Username masih kosong!", Toast.LENGTH_LONG).show();
                }else {
                    sp.save(context,"username",username);
                    Intent menu = new Intent(MainActivity.this, menu.class);
                    startActivity(menu);
                    Toast.makeText(getBaseContext(), "Berhasil Login!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
