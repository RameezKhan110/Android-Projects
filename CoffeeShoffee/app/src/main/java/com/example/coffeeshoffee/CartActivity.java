package com.example.coffeeshoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.coffeeshoffee.Adapters.CartAdapters;
import com.example.coffeeshoffee.Models.CartModels;
import com.example.coffeeshoffee.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<CartModels> list = helper.getOrders();

        CartAdapters adapters = new CartAdapters(list, this);
        binding.cartrecyclerview.setAdapter(adapters);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        binding.cartrecyclerview.setLayoutManager(linearLayout);
    }
}