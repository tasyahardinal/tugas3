package com.example.tasya3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private ArrayList<Heroes> listHero;
    private Context context;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getListHero() {
        return listHero;
    }

    public void setListHero(ArrayList<Heroes> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int y) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_listpahlawan, viewGroup, false);
        return new ViewHolder(itemRow);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int y) {
        Glide.with(context).load(getListHero().get(y).getHeroImage()).into(viewHolder.ivhero);
        viewHolder.tvnama.setText(getListHero().get(y).getHeroName());
        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailpahlawan.class);
                intent.putExtra("img_url", getListHero().get(y).getHeroImage());
                intent.putExtra("name", getListHero().get(y).getHeroName());
                intent.putExtra("detail", getListHero().get(y).getHeroDetail());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroName = "This is a hero" + getListHero().get(y).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "share Using"));
            }
        });
    }


    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivhero;
        TextView tvnama;
        Button btnShow,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivhero = itemView.findViewById(R.id.heroimage);
            tvnama = itemView.findViewById(R.id.heroname);
            btnShow = itemView.findViewById(R.id.btn_show);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}
