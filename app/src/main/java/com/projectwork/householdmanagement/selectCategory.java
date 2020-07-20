package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class selectCategory extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv1;

    ArrayList<Category> array = new ArrayList<Category>();
    CustomSelect adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper helper = new DBHelper(this);
        List<Category> list = helper.retriveData();
        array.addAll(list);

        adapter = new CustomSelect (this,R.layout.custom_select,array);
        lv1= findViewById(R.id.select_category_list);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int arg2, long arg3)
    {
        int id_To_Search = arg2 + 1;
        Intent intent = new Intent();
        intent.putExtra("id", id_To_Search);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, addExpences.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
