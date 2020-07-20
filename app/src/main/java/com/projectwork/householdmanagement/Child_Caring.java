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



public class Child_Caring extends AppCompatActivity {

    private ArrayList<Child> mSportsData;
    private childAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child__caring);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        CollapsingToolbarLayout collapsingToolbar =
                findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Child Care");

        loadBackdrop();




        //Initialize the RecyclerView
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize the ArrayList that will contain the data
        mSportsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new childAdapter(this, mSportsData);
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
                Collections.swap(mSportsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mSportsData.remove(viewHolder.getAdapterPosition());

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
        String[]childList = getResources().getStringArray(R.array.ChildTitles);
        String[] childInfo = getResources().getStringArray(R.array.ChildInfo);
        String[] childDetail = getResources().getStringArray(R.array.ChildDetail);
        String[] childNews = getResources().getStringArray(R.array.ChildNews);
        TypedArray childImageResources = getResources().obtainTypedArray(R.array.ChildCareImage);
        //Clear the existing data (to avoid duplication)
        mSportsData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<childList.length; i++){
            mSportsData.add(new Child(childList[i], childInfo[i], childDetail[i],childNews[i],
                    childImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        childImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }


    public void resetChildCareList(View view) {
        initializeData();
    }

    private void loadBackdrop() {
        final ImageView imageView = findViewById(R.id.backdrop);
        Glide.with(this).load(Cheeses.getRandomChildDrawable()).centerCrop().into(imageView);
    }
}
