package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lihatfilm extends AppCompatActivity {
    protected Cursor cursor;
    sql1 dbHelper;
    TextView txtjudulfilm, txtjudulversiindonesia, txttahuntayang, txtperingkat;
    Button btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatfilm);
        dbHelper = new sql1(this);
        txtjudulfilm = (TextView) findViewById(R.id.txtjudulfilm);
        txtjudulversiindonesia = (TextView) findViewById(R.id.txtjudulversiindonesia);
        txttahuntayang = (TextView) findViewById(R.id.txttahuntayang);
        txtperingkat = (TextView) findViewById(R.id.txtperingkat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "SELECT * from film WHERE judul_film = '"+getIntent().getStringExtra("judul film")+"'";
        cursor = db.rawQuery(sql1,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            txtjudulfilm.setText(cursor.getString(1).toString());
            txtjudulversiindonesia.setText(cursor.getString(2).toString());
            txttahuntayang.setText(cursor.getString(3).toString());
            txtperingkat.setText(cursor.getString(4).toString());
        }
        btnkembali = (Button) findViewById(R.id.btnkembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //
                finish();
            }
        });
    }
}
