package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
//https://mobprog.webug.se/json-api?login=a22chrfa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //new JsonTask(this).execute("kuk.se");
    }

    @Override
    public void onPostExecute(String json) {

    }
}
