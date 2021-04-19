package com.example.android.a108590002_hw7_045;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.LinkedList;

public class Com_tam extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView image;
    LinkedList<String> comtam = new LinkedList<String>( Arrays.asList(
            "For the Pork Chop:",
            "4 boneless pork chops",
            "2 tbsp oil",
            "2-3 cloves garlic (minced)",
            "2 tbsp soy sauce",
            "2 tbsp honey",
            "2 tbsp fish sauce",
            "For the Fish Sauce:",
            "2 tbsp vinegar",
            "2 lemons (juiced)",
            "6 tbsp fish sauce",
            "3 tbsp sugar",
            "3 cloves garlic (minced)",
            "3 cups warm water",
            "For the Egg Meatloaf:",
            "40g bean threads (soaked and chopped)",
            "½ cup dried wood ear mushrooms (soaked and chopped finely)",
            "3 tbsp shallot (minced)",
            "4 eggs",
            "200g minced pork",
            "1 tbsp oil",
            "1 tbsp fish sauce",
            "½ tsp salt",
            "½ tsp pepper",
            "For Serving: ",
            "4 cups of broken rice (cooked)",
            "4 fried eggs",
            "Pickled carrots and radishes",
            "Cucumber (de-seeded and sliced)",
            "Soy sauce (to garnish)",
            "Shredded pork skin (bi)",
            "Spring onion (chopped and sautéed slightly)",
            " ",
            "Procedure:",
            "Grilled Pork:",
            "Add Ingredient A into a bowl, stir until sugar fully dissolved. Place pork on a plate then pour in Ingredient A, make sure the marinate sauce are covering each surface of the pork evenly. Cover the plate and leave to marinate for 2 hours.",
            "Heat up a grill, put the marinated pork on top and let it grill for 10 minutes, flip side after 5 minutes. Remove pork from grill and cut into slices then arrange on a plate. Ready to serve.(Can use oven to replace grill, just make sure to observe and flip side when one side is cooked)",
            "Egg Meatloaf:",
            "Add Ingredient A into a bowl and mix evenly. Prepare a glass container and brush around the inner part with cooking oil, pour egg mixture into the container then set aside.",
            "Place container into the steamer and steam for 15 minutes over medium heat. Pour the egg yolk on top of the steamed egg and continue to steam for another 5 minutes.(Be sure to stir the egg yolk before pouring on top of the steamed egg.)",
            "Carrot Pickles:",
            "Mix Ingredient A in a bowl and gently toss for 5 minutes, wash the vegetables with tap water then rinse dry and set aside.",
            "Pour Ingredient B in a jar and stir well, Add Ingredient A into the jar and close the jar cover let marinate for 1 hour. Ready to serve.(If place in the fridge can store for up to 4 weeks)",
            "Fish Sauce:",
            "Add Ingredient A into a bowl, keep mashing until sugar fully dissolved. Toss in Ingredient B then mix and stir well. Ready to serve.",
            "Broken Rice:",
            "Wash and rinse rice a few times until water becomes clear. Place soaked rice into rice cooker and pour water enough to cover the rice. Set to cook using the rice cooker.(Soak rice with water for 1 hour in the rice cooker before cooking for a better outcome.)",
            "Scoop then place rice in the middle of a plate, then arrange Ingredient B accordingly around the plate Ready to serve."));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.recyclerview );
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, comtam);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        image = findViewById( R.id.imageView);
        image.setImageResource( R.drawable.com_tam );
    }
}