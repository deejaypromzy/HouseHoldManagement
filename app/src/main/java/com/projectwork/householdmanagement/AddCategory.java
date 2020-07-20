package com.projectwork.householdmanagement;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.ByteArrayOutputStream;

public class AddCategory extends AppCompatActivity implements View.OnClickListener{
    ImageButton i_btn1;
    EditText editText;
    Button  addCat,Cancel;

    int i=R.drawable.ic_reset;
    byte[] img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        addCat = findViewById(R.id.add_categorybtn);
        Cancel = findViewById(R.id.cancelBtn);
        i_btn1 = findViewById(R.id.add_category_image_btn);
        editText = findViewById(R.id.add_category_e1);

        addCat.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        i_btn1.setOnClickListener(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    android.content.Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        i = data.getIntExtra("image",R.drawable.ic_reset);
        i_btn1.setImageResource(i);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.cancelBtn:
                onBackPressed();
                break;
            case R.id.add_categorybtn:
                String str = editText.getText().toString().trim();
                if(str.equals(""))
                {
                    Toast.makeText(this, "Can't LEAVE blank field", Toast.LENGTH_LONG).show();
                }
                else
                {
                    // enter image into database
                    Bitmap b= BitmapFactory.decodeResource(getResources(), i);
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    b.compress(Bitmap.CompressFormat.PNG, 100, bos);
                    img=bos.toByteArray();// to change into byte
                    // Create category class Reference
                    Category category = new Category(str, img);
                    // DBHelper class
                    DBHelper helper = new DBHelper(this);
                    helper.insertData(category);
                    i_btn1.setImageResource(R.drawable.ic_reset);
                    editText.setText("");

//                    startActivity(new Intent(this,Personal_Finance_and_Budgeting.class));

                }
                break;
            case R.id.add_category_image_btn:
                Intent intent = new Intent(this, SelectIcon.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
