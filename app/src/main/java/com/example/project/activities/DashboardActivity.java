package com.example.project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project.R;
import com.example.project.model.CreditCard;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private List<CreditCard> creditCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
}