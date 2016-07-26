package com.pokescannerapp.android.pokemon.adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokescannerapp.android.R;
import com.pokescannerapp.android.pokemon.models.PokedexEntry;
import com.pokescannerapp.android.pokemon.models.WildPokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NearbyPokemonAdapter extends RecyclerView.Adapter {

    private Activity mActivity;
    private List<WildPokemon> mWildPokemons;
    private  List<PokedexEntry> mPokedexEntries;

    public NearbyPokemonAdapter(Activity activity, List<WildPokemon> wildPokemons, List<PokedexEntry> pokedexEntries) {
        mActivity = activity;
        mWildPokemons = wildPokemons;
        mPokedexEntries = pokedexEntries;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_nearby_pokemon, parent, false);
        return new PokemonHolder(v, mActivity);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PokemonHolder) holder).bind(mWildPokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return mWildPokemons.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pokemon_name)
        TextView tvPokemonName;

        @BindView(R.id.tv_pokemon_type)
        TextView tvPokemonType;

        @BindView(R.id.iv_pokemon_image)
        ImageView ivPokemonImage;
        private Activity mActivity;

        WildPokemon mWildPokemon;
        PokedexEntry mPokedexEntry;

        public PokemonHolder(View itemView, Activity activity) {
            super(itemView);
            mActivity = activity;
            ButterKnife.bind(this, itemView);
        }

        public void bind(WildPokemon wildPokemon) {
            mPokedexEntry = mPokedexEntries.get(wildPokemon.getPokemon().getPokemonId() - 1);
            tvPokemonName.setText(mPokedexEntry.getName());
            tvPokemonType.setText(mPokedexEntry.getType());
            Picasso.with(mActivity).load(mPokedexEntry.getImg()).into(ivPokemonImage);
            mWildPokemon = wildPokemon;
        }

        @OnClick(R.id.rl_nearby_pokemon)
        void clickNeabyPokemon() {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+ mWildPokemon.getLatitude() +"," + mWildPokemon.getLongitude() +"?q=" + mWildPokemon.getLatitude() + "," + mWildPokemon.getLongitude() + "(" + mPokedexEntry.getName() + ")"));
            mActivity.startActivity(intent);
        }
    }

}
