package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String [] namaBuah = {"Alpukat","Apel","Durian","Jambu",
                            "Manggis","Strawberry","Ceri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, namaBuah);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, namaBuah[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
