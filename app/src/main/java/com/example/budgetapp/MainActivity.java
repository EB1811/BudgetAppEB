package com.example.budgetapp;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);

        Button addExpense = (Button) findViewById(R.id.addExpenseButton);
        addExpense.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ConstraintLayout expenseData = findViewById(R.id.newDataBox);

                expenseData.setVisibility(View.VISIBLE);
            }
        });

        Button confirmExpense = (Button) findViewById(R.id.confirmNewExpense);

        confirmExpense.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText budgetData = findViewById(R.id.budgetInput);
                EditText expensesData = findViewById(R.id.expensesInput);

                LinearLayout dataViewVar = findViewById(R.id.dataViewLayout);

                // Add a TextView
                TextView textView = new TextView(MainActivity.this);

                // Math to get result.
                int num1 = Integer.parseInt(budgetData.getText().toString());
                int num2 = Integer.parseInt(expensesData.getText().toString());
                int result = num1 - num2;

                // Set text on TextView.
                textView.setText(result + "");


                // Add the TextView into the ScrollView.
                dataViewVar.addView(textView);

                // Hide the form
                ConstraintLayout expenseData = findViewById(R.id.newDataBox);
                expenseData.setVisibility(View.GONE);
            }
        });

    }
}
