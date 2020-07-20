package com.projectwork.householdmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;
import java.util.Date;

public class addExpences extends AppCompatActivity implements View.OnClickListener{

    Button send,cancel;
    EditText select_category,amount;
    // DatePicker myDate;
    String date;
    int i=0;


    String category="";

    static final int DATE_DIALOG_ID =999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        amount = findViewById(R.id.expense_amount);
        select_category = findViewById(R.id.expenseCategory);
        send = findViewById(R.id.sendBtn);
        cancel = findViewById(R.id.cancelBtn);


        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
        select_category.setOnClickListener(this);

        //    myDate = findViewById(R.id.expenseDate);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Category cat = new Category();
        DBHelper hepler = new DBHelper(this);
        int Value = data.getIntExtra("id", 0);
        if (Value > 0) {
            cat = hepler.getData(Value);
            // id_To_Update = Value;
        }
        category = cat.getCategory();
        select_category.setText(cat.getCategory());

        i = 1;
    }

    private void database(String category, int expense) {
        ///date = String.valueOf(myDate.getDayOfMonth()+"/"+myDate.getMonth()+1+"/"+myDate.getYear());

        Expense epnse = new Expense(category, expense );
        // DBHelper class
        DBHelper helper = new DBHelper(this);
        helper.insertData(epnse);
        select_category.setText(null);
        amount.setText(null);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendBtn:
                String amount1 = (amount.getText().toString());
                String old_income, old_expense;
                int j = R.drawable.ic_reset;
                double value;

                if (amount.getText().toString().equals("")) {
                    Toast.makeText(this, "Plz Enter Amount", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, date, Toast.LENGTH_LONG).show();

                } else if (category.equals("")) {
                    Toast.makeText(this, "Plz Select Category", Toast.LENGTH_LONG).show();
                } else {
                    //Preference
                    SharedPreferences preferences1 = getSharedPreferences("Income", 0);
                    old_income = preferences1.getString("old_income", "0.00");
                    old_expense = preferences1.getString("expense", "0.00");
                    value = Double.parseDouble(old_income) - Double.parseDouble(amount1);
                    SharedPreferences.Editor editor = preferences1.edit();
                    editor.putString("old_income", Double.toString(value));
                    value = Double.parseDouble(old_expense) + Double.parseDouble(amount1);
                    editor.putString("expense", Double.toString(value));
                    editor.apply();


                    int expense = Integer.parseInt(amount1);
                    // to add to the database;
                    database(category, expense);

//                    Intent intent = new Intent(addExpences.this, Personal_Finance_and_Budgeting.class);
//                    startActivity(intent);
                    finish();
                }
                break;

            case R.id.expenseCategory:
                Intent intent = new Intent(this, selectCategory.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.cancelBtn:
               onBackPressed();
                break;
            default:
                break;
        }
    }
}
