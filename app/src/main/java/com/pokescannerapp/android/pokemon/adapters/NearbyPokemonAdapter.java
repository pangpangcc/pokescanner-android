package com.pokescannerapp.android.pokemon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pokescannerapp.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NearbyPokemonAdapter extends RecyclerView.Adapter {

    ArrayList<String> mStringArrayList;

    public NearbyPokemonAdapter(ArrayList<String> stringArrayList) {
        mStringArrayList = stringArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_nearby_pokemon, parent, false);
        return new PokemonHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PokemonHolder) holder).bind(mStringArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pokemon_name)
        TextView tvPokemonName;

        public PokemonHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String name) {
            tvPokemonName.setText(name);
        }
    }

}
