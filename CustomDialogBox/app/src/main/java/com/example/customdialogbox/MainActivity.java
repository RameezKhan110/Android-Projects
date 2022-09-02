package com.example.customdialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btn, Yes, No;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn = findViewById(R.id.exit);
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.customdialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Yes = dialog.findViewById(R.id.yes);
        No = dialog.findViewById(R.id.no);

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                finish();
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
            }
        });
    }
}