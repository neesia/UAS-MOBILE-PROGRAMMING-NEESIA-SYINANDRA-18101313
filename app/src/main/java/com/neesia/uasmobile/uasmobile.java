package com.neesia.uasmobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class uasmobile {
    public static final String Prefs_name = "Share_Pref_Aplikasi";

    public uasmobile () {
        super();
    }

    public void save (Context context, String key, String text){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(key, text);
        editor.commit();
    }

    public String getValue(Context context, String key){
        SharedPreferences settings;
        String text;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        text = settings.getString(key, null);
        return text;
    }

    public void clearuasmobile(Context context){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();
    }

}
