package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmicalculation extends AppCompatActivity {
    android.widget.Button recalculatebmi;
    TextView mbmidisplay, mbmicategory, mgender;
    ImageView mimageView;
    Intent intent;
    String mbmi;
    float intbmi;
    String weight, height;
    float intheight, intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculation);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("font color = \"white\"></font"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent =getIntent();
        recalculatebmi = findViewById(R.id.recalculatebmi);
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mimageView = findViewById(R.id.imageview);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;
        intbmi = intweight/(intheight*intheight);

        mbmi = Float.toString(intbmi);

        if(intbmi<16){
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        }
        else if(intbmi<16.9 && intbmi>16){
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi<18.4 && intbmi>19){
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi<25 && intbmi>18.4){
            mbmicategory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageView.setImageResource(R.drawable.ok);
        }
        else if(intbmi<29.4 && intbmi>25){
            mbmicategory.setText("Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        }
        else{
            mbmicategory.setText("Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        getSupportActionBar().hide();

        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bmicalculation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}