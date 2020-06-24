package com.neesia.uasmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class databuku extends AppCompatActivity {
    String[] daftar;
    Menu menu;
    ListView ListView1;
    sql dbHelper;
    public static databuku ma;
    protected Cursor cursor;
    Button btndatabuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databuku);
        ma = this;
        dbHelper = new sql(this);
        btndatabuku = (Button) findViewById(R.id.btndatabuku);
        RefreshList();


    }


    public void RefreshList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM buku", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        ListView1 = (ListView) findViewById(R.id.ListView1);
        ListView1.setAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, daftar));
        ListView1.setSelected(true);
        ((ArrayAdapter) ListView1.getAdapter()).notifyDataSetInvalidated();
        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String selection = daftar[position];
                final String[] dialogitem = new String[]{"Edit", "Lihat", "Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(databuku.this);
                builder.setTitle("Pilih!");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent intent = new Intent(databuku.this, editactivity.class);
                                intent.putExtra("judul buku", selection);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(databuku.this, lihat.class);
                                intent1.putExtra("judul buku", selection);
                                startActivity(intent1);
                                break;
                            case 2:
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                String sql = "DELETE from buku WHERE judul_buku='" + selection + "'";
                                db.execSQL(sql);
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        menu.add(0, 1, 0, "Tambah");
        menu.add(0, 2, 0, "Refresh");
        menu.add(0, 3, 0, "Exit");
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                //koding menambahkan activity tambah
                Intent intent = new Intent(databuku.this, tambahactivity.class);
                startActivity(intent);
                return true;
            case 2:
                RefreshList();
                return true;
            case 3:
                finish();
                return true;
        }
        return false;
    }
}
