package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BuahActivity extends AppCompatActivity {
    RecyclerView rvBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);

        rvBuah = findViewById(R.id.rv_buah);
        rvBuah.setLayoutManager(new LinearLayoutManager(this));

        int[] gambarBuah = {R.drawable.alpukat, R.drawable.apel, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry, R.drawable.ceri};
        int[] songBuah = {R.raw.alpukat, R.raw.apel, R.raw.durian, R.raw.jambu_air, R.raw.manggis, R.raw.strawberry, R.raw.ceri};

        String [] namaBuah = {"Alpukat","Apel","Durian","Jambu",
                "Manggis","Strawberry","Ceri"};

        BuahAdapter adapter = new BuahAdapter( namaBuah, gambarBuah, songBuah);

        rvBuah.setAdapter(adapter);
    }
}
