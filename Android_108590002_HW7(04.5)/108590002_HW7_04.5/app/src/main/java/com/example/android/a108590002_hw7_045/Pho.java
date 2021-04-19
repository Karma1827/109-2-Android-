package com.example.android.a108590002_hw7_045;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.LinkedList;

public class Pho extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView image;
    LinkedList<String> pho = new LinkedList<String>( Arrays.asList(
            "Ingredient A:",
            "0.5 segment Ginger",
            "0.5 pcs Onion",
            "Ingredient B",
            "250g Beef Bone",
            "0.75 litre Water",
            "Ingredient C",
            "2 pcs Star Anise",
            "1 pcs Cloves",
            "0.5 stick Cinnamon Stick",
            "1 tsp Salt",
            "1 tbsp Fish Sauce",
            "Ingredient D",
            "100g Banh Pho Noodles",
            "100g Beef Slice",
            "Ingredient E",
            "0.5 tsp Ground Black Pepper",
            "0.5/2 pcs Minced Onion",
            "1 sprigs Minced Scallion",
            " ",
            "Procedure:",
            "Place Ingredient A into the preheating oven and let roast for 10 minutes until turn golden brown.(Remove burnt surface from the onion and set aside for later use.)",
            "Add Ingredient B into a pot and let boil for 10 minutes. Pour the scum water out into the sink then refill the pot again with water, bring the water to boil over high heat.(Use a strainer to remove meat scums from the broth occasionally.)",
            "Continue by adding Ingredient A and Ingredient C into the pot and let simmer over low heat for 2 hours.(Taste and adjust the broth using fish sauce and salt.)",
            "Heat up a saucepan with water, add Banh Pho Noodle and blanch until noodle turns opaque white, transfer to a plate. Continue by adding beef slice into the saucepan and cook for 3 minutes then retrieve and set aside.",
            "Place Noodle into 2 separate bowls as base Ingredient, add beef slice on top of the noodle then pour beef broth into the bowl. Sprinkle Ingredient E around the bowl as garnishes. Ready to serve.(You may add bean sprout, lime wedges, coriander or mint leaves for this dish.)"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.recyclerview );
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, pho);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        image = findViewById( R.id.imageView);
        image.setImageResource( R.drawable.pho );
    }
}
