package com.example.project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private ArrayList<Art> artObjects;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter artAdapter;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22chrfa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonTask(this).execute(JSON_URL);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewID);
        artObjects = new ArrayList<Art>();
        // Create adapter passing in the sample user data
        artAdapter = new RecyclerViewAdapter(artObjects);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(artAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onPostExecute(String json) {
        ArrayList<Art> data = new Gson().fromJson(json, new TypeToken<ArrayList<Art>>(){}.getType());
        artObjects.addAll(data);
        Log.d("==> Data: ", data.toString());
        artAdapter.notifyDataSetChanged();
    }
}
