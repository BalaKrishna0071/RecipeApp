package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipeapp.Listners.RecipeDetailsListener;
import com.example.recipeapp.Models.RecipeDetailsResponse;

public class RecipeDetailsActivity extends AppCompatActivity {
    int id;
    TextView textView_meal_name,textview_meal_source,textview_meal_summary;
    ImageView imageview_meal_image;
    RecyclerView recycler_meal_ingredients;
    RequestManager manager;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        findViews();
        id = Integer.parseInt(getIntent().getStringExtra("id"));
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener,id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading....");
        dialog.show();
    }

    private void findViews() {
        textView_meal_name = findViewById(R.id.textView_meal_name);
        textview_meal_source = findViewById(R.id.textview_meal_source);
        textview_meal_summary = findViewById(R.id.textview_meal_summary);
        imageview_meal_image = findViewById(R.id.imageview_meal_image);
        recycler_meal_ingredients = findViewById(R.id.recycler_meal_ingredients);



    }
    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener() {
        @Override
        public void didFetch(RecipeDetailsResponse response, String message) {

        }

        @Override
        public void didError(String message) {

        }
    };
}