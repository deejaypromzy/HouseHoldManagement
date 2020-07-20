//package com.projectwork.householdmanagement;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.TextView;
////
////import com.github.clans.fab.FloatingActionButton;
////import com.github.clans.fab.FloatingActionMenu;
//import com.jesusm.holocircleseekbar.lib.HoloCircleSeekBar;
//
//import java.io.ByteArrayOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import pl.bclogic.pulsator4droid.library.PulsatorLayout;
//
//public class Personal_Finance_and_Budgeting extends AppCompatActivity implements View.OnClickListener {
//    boolean flag;
//    TextView TotalIncome,TotalExpenses,Income;
//    String IncomeValue,ExpensesValue,IncomeLeft;
//    AppCompatButton addExpence,addIncome,History,addCategory;
//    HoloCircleSeekBar seekBar;
//    PulsatorLayout mPulsator;
//
//    float value;
//    String old_income, old_expense;
//    SharedPreferences prefere;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_personal__finance_and__budgeting);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setLogo(R.mipmap.ic_budget);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        addExpence = findViewById(R.id.AddExpenses);
//        addIncome = findViewById(R.id.AddIncome);
//        History = findViewById(R.id.AccountHistory);
//        addCategory = findViewById(R.id.AddNewCategory);
//
//
//        addExpence.setOnClickListener(this);
//        addIncome.setOnClickListener(this);
//        History.setOnClickListener(this);
//        addCategory.setOnClickListener(this);
//
//
//
//        mPulsator = findViewById(R.id.pulsator);
//        seekBar = findViewById(R.id.picker);
//        seekBar.setMax(100);
//
//
//        // start pulsator
//        mPulsator.start();
//
//        seekBar.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });
//
//
//        TotalIncome = findViewById(R.id.totalIncome);
//        TotalExpenses = findViewById(R.id.totalExpenses);
//        Income= findViewById(R.id.Income);
//
//
//        SharedPreferences preferences = getSharedPreferences("Income", 0);
//        ExpensesValue = preferences.getString("expense", "0.00");
//        IncomeLeft = preferences.getString("old_income", "0.00");
//        IncomeValue = String.valueOf(Double.valueOf(ExpensesValue) + Double.valueOf(IncomeLeft));
//
//
//
//        setTextViewValues();
//
//
//
//
//        SharedPreferences preferences1 = getSharedPreferences("wallet", 0);
//        flag = preferences1.getBoolean("flag", true);
//        if(flag)
//        {
//            preferences1.edit().putBoolean("flag", false).apply();
//            DBHelper helper = new DBHelper(this);
//            preDefine(helper);
//        }
//
//        prefere= getSharedPreferences("Income", 0);
//        old_income = prefere.getString("old_income", "0.00");
//        old_expense = prefere.getString("expense", "0.00");
//
//
//        value =(float) (Double.parseDouble(ExpensesValue) / Double.valueOf(IncomeValue)) * 100;
//
//        if(value>0)
//            seekBar.setValue(value);
//        else
//            seekBar.setValue(0);
//
//
//
//    }
//
//    private void setTextViewValues() {
//
//        if(IncomeValue.equals("0.00"))
//            TotalIncome.setText(IncomeValue);
//        else
//            TotalIncome.setText(IncomeValue+" ");
//
//
//        //  SharedPreferences preferences2 = getSharedPreferences("Income", 0);
//        if(ExpensesValue.equals("0.00"))
//            TotalExpenses.setText(ExpensesValue);
//        else
//            TotalExpenses.setText(ExpensesValue+" ");
//
//
//        // SharedPreferences preferences3 = getSharedPreferences("Income", 0);
//        if(ExpensesValue.equals("0.00"))
//            Income.setText(IncomeLeft);
//        else
//            Income.setText(IncomeLeft+" ");
//
//        if(value>0)
//            seekBar.setValue(value);
//        else
//            seekBar.setValue(0);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        setTextViewValues();
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        setTextViewValues();
//
//    }
//
//
//
//    //pre Enter values Function
//    public void preDefine(DBHelper help)
//    {
//        Category cat;
//        int i;
//        byte[] img;
//        //Food & Drink
//        i = R.drawable.pic48;
//        Bitmap b = BitmapFactory.decodeResource(getResources(), i);
//        ByteArrayOutputStream bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Food & Drink", img);
//        help.insertData(cat);
//
//        // Transport
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Transport", img);
//        help.insertData(cat);
//
//        // Education
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Education", img);
//        help.insertData(cat);
//
//        // Entertainment
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Entertainment", img);
//        help.insertData(cat);
//
//        // Medical
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Medical", img);
//        help.insertData(cat);
//
//        // Shopping
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Shopping", img);
//        help.insertData(cat);
//
//        // Medical
//        i = R.drawable.pic48;
//
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Travel", img);
//        help.insertData(cat);
//
//        // Medical
//        i = R.drawable.pic48;
//        b = BitmapFactory.decodeResource(getResources(), i);
//        bos=new ByteArrayOutputStream();
//        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
//        img=bos.toByteArray();
//        cat = new Category("Other", img);
//        help.insertData(cat);
//    }
//
//    @Override
//    public void onClick(View view) {
//        int id = view.getId();
//        Intent intent;
//        switch (id){
//            case R.id.AddIncome:
//                intent = new Intent(this, addIncome.class);
//                startActivity(intent);
//                break;
//            case R.id.AddExpenses:
//                intent = new Intent(this, addExpences.class);
//                startActivity(intent);
//                break;
//            case R.id.AddNewCategory:
//                intent = new Intent(this, AddCategory.class);
//                startActivity(intent);
//                break;
//            case R.id.AccountHistory:
//                intent = new Intent(this, ViewExpenses.class);
//                startActivity(intent);
//                break;
//            default:
//                break;
//        }
//    }
//
//
//}
