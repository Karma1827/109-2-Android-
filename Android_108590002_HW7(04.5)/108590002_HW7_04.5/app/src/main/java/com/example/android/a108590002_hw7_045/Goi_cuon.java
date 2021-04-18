package com.example.android.a108590002_hw7_045;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.LinkedList;

public class Goi_cuon extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView image;
    LinkedList<String> goi_cuon = new LinkedList<String>( Arrays.asList(
            "Ingredient A:",
            "200g Pork Loin",
            "200g Shrimp",
            "200g Rice Vermicelli",
            "Ingredient B:",
            "1 tbsp Cooking Oil",
            "1 tbsp Minced Garlic",
            "4 tbsp Hoisin Sauce",
            "1 tbsp Sugar",
            "100ml Water",
            "Ingredient C:",
            "8 pcs Rice Paper",
            "4 sprigs Coriander",
            "1/2 stick Carrot",
            "12 leaves Mint Leaves",
            " ",
            "Procedure:",
            "Cook pork with water in a pot, then let it chill for a while and slice into thin pieces. Set aside for later use.",
            "Poach Shrimp in water with a pan, retrieve and cut in half from the middle. Set aside for later use.",
            "Cook Rice Vermicelli in hot water for 5 minutes, drain with cold water and rinse well. Set aside for later use.",
            "Heat up a pan with cooking oil, place minced garlic and stir fry until turn golden brown, add remaining Ingredient B into the pan and keep stirring until reach perfect thickness. Fill into a saucer and set aside.",
            "Take a piece of rice paper then gently dip into water and lay on a flat surface. Put Ingredient C and Ingredient A on the rice paper according to the portion you like then start to roll.(Rinse and repeat this steps until all ingredient fully used up.)",
            "Place Spring Rolls on a plate then put the sauce on the side as condiments. Ready to serve."));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.recyclerview );
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, goi_cuon);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        image = findViewById( R.id.imageView);
        image.setImageResource( R.drawable.goi_cuon );
    }
}