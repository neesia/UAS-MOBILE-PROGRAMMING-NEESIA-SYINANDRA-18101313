package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lihat extends AppCompatActivity {
    protected Cursor cursor;
    sql dbHelper;
    TextView txtjudulbuku, txtnamapengarang, txttahunterbit, txtpenerbit;
    Button btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);
        dbHelper = new sql(this);
        txtjudulbuku = (TextView) findViewById(R.id.txtjudulbuku);
        txtnamapengarang = (TextView) findViewById(R.id.txtnamapengarang);
        txttahunterbit = (TextView) findViewById(R.id.txttahunterbit);
        txtpenerbit = (TextView) findViewById(R.id.txtpenerbit);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * from buku WHERE judul_buku = '"+getIntent().getStringExtra("judul buku")+"'";
        cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            txtjudulbuku.setText(cursor.getString(1).toString());
            txtnamapengarang.setText(cursor.getString(2).toString());
            txttahunterbit.setText(cursor.getString(3).toString());
            txtpenerbit.setText(cursor.getString(4).toString());
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
