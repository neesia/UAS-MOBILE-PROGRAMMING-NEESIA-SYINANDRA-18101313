package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tambahfilm extends AppCompatActivity {
    sql1 dbHelper;
    Button btnsimpan;
    EditText txtjudulfilm, txtjudulversiindonesia, txttahuntayang, txtperingkat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahfilm);
        dbHelper = new sql1(this);
        txtjudulfilm = (EditText) findViewById(R.id.txtjudulfilm);
        txtjudulversiindonesia = (EditText) findViewById(R.id.txtjudulversiindonesia);
        txttahuntayang = (EditText) findViewById(R.id.txttahuntayang);
        txtperingkat = (EditText) findViewById(R.id.txtperingkat);
        btnsimpan = (Button) findViewById(R.id.btnsimpan);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql1 = "INSERT INTO film (judul_film, judul_versiindonesia, tahun_tayang, peringkat)" +
                        "       VALUES ('"+ txtjudulfilm.getText().toString()+"',"+
                        "               '"+ txtjudulversiindonesia.getText().toString()+"',"+
                        "               '"+ txttahuntayang.getText().toString()+"',"+
                        "               '"+ txtperingkat.getText().toString()+"')";
                db.execSQL(sql1);
                Toast.makeText(getApplicationContext(),"Berhasil Menambahkan Data",Toast.LENGTH_LONG).show();
                datafilm.ma.RefreshList();
                finish();
            }
        });
    }
}
