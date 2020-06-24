package com.neesia.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editfilm extends AppCompatActivity {
    EditText txtjudulfilm, txtjudulversiindonesia, txttahuntayang, txtperingkat;
    Button btnsimpan;
    sql1 dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editfilm);
        dbHelper = new sql1(this);
        txtjudulfilm = (EditText) findViewById(R.id.txtjudulfilm);
        txtjudulversiindonesia = (EditText) findViewById(R.id.txtjudulversiindonesia);
        txttahuntayang = (EditText) findViewById(R.id.txttahuntayang);
        txtperingkat = (EditText) findViewById(R.id.txtperingkat);
        btnsimpan = (Button) findViewById(R.id.btnsimpan);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "SELECT * from film WHERE judul_film = '"+getIntent().getStringExtra("judul film")+"'";
        cursor = db.rawQuery(sql1,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            txtjudulfilm.setText(cursor.getString(1).toString());
            txtjudulversiindonesia.setText(cursor.getString(2).toString());
            txttahuntayang.setText(cursor.getString(3).toString());
            txtperingkat.setText(cursor.getString(4).toString());
        }
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql1 = "UPDATE film SET judul_film ='"+ txtjudulfilm.getText().toString() +"',"+
                        " judul_versiindonesia ='"+ txtjudulversiindonesia.getText().toString() +"',"+
                        " tahun_tayang ='"+ txttahuntayang.getText().toString() +"',"+
                        "  peringkat ='"+ txtperingkat.getText().toString() +"'"+
                        "WHERE judul_film ='"+ getIntent().getStringExtra("judul film")+"'";
                db.execSQL(sql1);
                Toast.makeText(getApplicationContext(),"Berhasil Mengubah Data", Toast.LENGTH_LONG).show();
                datafilm.ma.RefreshList();
                finish();
            }
        });
    }
}
