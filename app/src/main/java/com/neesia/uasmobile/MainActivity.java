package com.neesia.uasmobile;

import androidx.appcompat.app.AlertDialog;
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
                String password = txtpassword.getText().toString();

                if (username.equals("neesia") && password.equals("1234")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Anda berhasil Login!",Toast.LENGTH_LONG).show();
                    Intent menu = new Intent(MainActivity.this, menu.class);
                    sp.save(context,"username", username);
                    MainActivity.this.startActivity(menu);
                    Toast.makeText(getBaseContext(), "Berhasil Login!", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Anda Salah!").setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }

}
