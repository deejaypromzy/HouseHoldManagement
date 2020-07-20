package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class ViewExpenses extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView li, li2;
    ArrayAdapter<StringBuffer> adapter;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expenses);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        li = findViewById(R.id.view_expense_list);


        db = new DBHelper(this);

        List<StringBuffer> list = db.showexpense();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        li.setAdapter(adapter);


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

    }
}
