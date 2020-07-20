package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


public class main extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab1;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);

        fab1 = findViewById(R.id.fab1);
        fab1.setOnClickListener(this);


        FloatingActionMenu menuBlue = findViewById(R.id.menu_blue);
        menuBlue.setIconAnimated(true);
        menuBlue.hideMenuButton(false);

        menus.add(menuBlue);
        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab1:
//                ConversationActivity.show(this);
                break;
        }
    }




    public void gotoChildCare (View view){
        startActivity(new Intent(main.this,Child_Caring.class));
    }

    public void gotoCleaningAndLaundry (View view){
        startActivity(new Intent(main.this,Cleaning_and_Laundry.class));
    }

    public void gotoCookingRecipe (View view){
        startActivity(new Intent(main.this,Cooking_Recipe.class));
    }

    public void gotoFinanceAndBudgeting (View view){
//       startActivity(new Intent(main.this,Personal_Finance_and_Budgeting.class));

   /*     Smooch.init(getApplication(), new Settings("5aaed64c891651002256f5dd"), new SmoochCallback() {
            @Override
            public void run(Response response) {
if(response.getError()==null){
    ConversationActivity.show(getApplicationContext());
}
            }
        });*/

    }

    public void gotoRoomDecoration (View view){
        startActivity(new Intent(main.this,Room_Decoration_and_Bed_Making.class));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.exit:
                super.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void gotoBedMaking(View view) {
        startActivity(new Intent(main.this,BedMaking.class));

    }
}
