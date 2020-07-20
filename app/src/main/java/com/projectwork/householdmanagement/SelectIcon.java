package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SelectIcon extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;
    Integer img[] = {R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48,R.drawable.pic48};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_icon);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = findViewById(R.id.icon_grid);
        gridView.setAdapter(new CustomImage(this));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                            long arg3)
    {
        Intent intent = new Intent();
        intent.putExtra("image",img[arg2]);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, AddCategory.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }


}
