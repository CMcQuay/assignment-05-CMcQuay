package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ualr.layoutassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money
    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label
    private CheckBox checkboxProduct01;
    private CheckBox checkboxProduct02;
    private CheckBox checkboxProduct03;
    private CheckBox checkboxProduct04;

    private EditText editTextProduct01;
    private EditText editTextProduct02;
    private EditText editTextProduct03;
    private EditText editTextProduct04;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        checkboxProduct01 = findViewById(R.id.checkboxProduct01);
        checkboxProduct02 = findViewById(R.id.checkboxProduct02);
        checkboxProduct03 = findViewById(R.id.checkboxProduct03);
        checkboxProduct04 = findViewById(R.id.checkboxProduct04);

        editTextProduct01 = findViewById(R.id.editTextProduct01);
        editTextProduct02 = findViewById(R.id.editTextProduct02);
        editTextProduct03 = findViewById(R.id.editTextProduct03);
        editTextProduct04 = findViewById(R.id.editTextProduct04);

        Button btnCalculateTotal = findViewById(R.id.btnCalculateTotal);
        TextView textTotal = findViewById(R.id.textTotal);
        btnCalculateTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the calculateTotal method and update textTotal with the result
                double totalAmount = calculateTotal();
                textTotal.setText(String.format("%.2f", totalAmount));
            }
        });
    }
    private double parseEditTextValue(EditText editText) {
        try {
            String valueString = editText.getText().toString();
            if (!valueString.isEmpty()) {
                return Double.parseDouble(valueString);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private double calculateTotal() {
        double totalAmount = 0;

        if (checkboxProduct01.isChecked()) {
            totalAmount += parseEditTextValue(editTextProduct01);
        }

        if (checkboxProduct02.isChecked()) {
            totalAmount += parseEditTextValue(editTextProduct02);
        }

        if (checkboxProduct03.isChecked()) {
            totalAmount += parseEditTextValue(editTextProduct03);
        }

        if (checkboxProduct04.isChecked()) {
            totalAmount += parseEditTextValue(editTextProduct04);
        }

        return totalAmount;
    }
}