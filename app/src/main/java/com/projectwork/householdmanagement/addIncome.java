package com.projectwork.householdmanagement;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class addIncome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void IncomeBtn(View view){

        switch (view.getId())
        {
            case R.id.sendBtn:

                EditText edit = findViewById(R.id.income_amount);
                String str = (edit.getText().toString());
                String old_value;
                double value;
                if(str.equals(""))
                {
                    Toast.makeText(addIncome.this, "Can't Leave Blank Field", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SharedPreferences preferences = getSharedPreferences("Income", 0);
                    old_value = preferences.getString("old_income", "0.00");
                    value = Double.parseDouble(old_value)+Double.parseDouble(str);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("new_income", str);
                    editor.putString("old_income", Double.toString(value));
                    editor.apply();
                    this.onBackPressed();
                }

            break;

            case R.id.cancelBtn:
                super.onBackPressed();
                break;
            default:
                break;
        }



        }
    }

