package com.example.listviewandrecyclerview;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {


    //TODO 3 Bikin variable dan jadikan konstruktor
    private String [] namaBuah;
    private int [] gambarBuah;
    private int [] songBuah;

    public BuahAdapter(String[] namaBuah, int[] gambarBuah, int[] songBuah) {
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.songBuah = songBuah;
    }

    //TODO 1 Masukkan layout untuk menampilkan data
    @NonNull
    @Override
    public BuahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buah,parent,false);
        return new MyViewHolder(view);
    }

    //TODO 4 Tampilkan data
    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.MyViewHolder holder, final int position) {
        holder.imgBuah.setImageResource(gambarBuah[position]);
        holder.tvNamaBuah.setText(namaBuah[position]);

        //TODO 6 atur onClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(songBuah[position], position, view);
            }
        });

    }

    //TODO 5 Hitung data
    @Override
    public int getItemCount() {
        return namaBuah.length;
    }


    //TODO 2 Deklarasi dan inisialisasi yang ada di layout
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaBuah;
        ImageView imgBuah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaBuah = itemView.findViewById(R.id.item_text);
            imgBuah = itemView.findViewById(R.id.item_image);
        }
    }

    private void playSong(int  songBuah, int position, View view){
        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Uri uri = Uri.parse("android.resource://"+getClass().getPackage().getName()+"/"+songBuah);
        try {
            player.setDataSource(view.getContext(), uri);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.start();
    }

}
