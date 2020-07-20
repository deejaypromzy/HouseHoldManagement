package com.projectwork.householdmanagement;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.Collections;

public class Cooking_Recipe extends AppCompatActivity {
    private ArrayList<Child> mData;
    private childAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking__recipe);


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("GH-Dish Recipe");

        loadBackdrop();




        //Initialize the RecyclerView
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize the ArrayList that will contain the data
        mData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new childAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mData.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] dishList = getResources().getStringArray(R.array.DishTitles);
        String[] dishInfo = getResources().getStringArray(R.array.DishInfo);
        String[] dishDetail = getResources().getStringArray(R.array.DishDetail);
        String[] dishdNews = getResources().getStringArray(R.array.DishdNews);
        TypedArray childImageResources = getResources().obtainTypedArray(R.array.DishImages);
        //Clear the existing data (to avoid duplication)
        mData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<dishList.length; i++){
            mData.add(new Child(dishList[i], dishInfo[i],dishDetail[i],dishdNews[i],
                    childImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        childImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }


    public void resetDishList(View view) {
        initializeData();
    }

    private void loadBackdrop() {
        final ImageView imageView = findViewById(R.id.backdrop);
        Glide.with(this).load(Cheeses.getRandomDishDrawable()).centerCrop().into(imageView);
    }
}
