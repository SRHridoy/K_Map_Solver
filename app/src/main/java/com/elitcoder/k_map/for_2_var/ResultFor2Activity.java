package com.elitcoder.k_map.for_2_var;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.k_map.OptionActivity;
import com.elitcoder.k_map.R;
import com.elitcoder.k_map.databinding.ActivityResultFor2Binding;
import com.elitcoder.k_map.for_3_var.ResultFor3Activity;

public class ResultFor2Activity extends AppCompatActivity {
    ActivityResultFor2Binding resultFor2Binding;
    private int[] kmapValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Binding:
        resultFor2Binding = ActivityResultFor2Binding.inflate(getLayoutInflater());
        View view = resultFor2Binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Retrieve the simplified K-map result string:
        String result = getIntent().getStringExtra("simplified_result");
        kmapValues = getIntent().getIntArrayExtra("kmap_values");

        //Working on Truth Table:
        showTable();

        //Show Result:
        if (result != null) {
            resultFor2Binding.txtResult.setText("The Simplified function is: " + result);
            Toast.makeText(this, "Successfully Simplified!", Toast.LENGTH_SHORT).show();
        } else {
            resultFor2Binding.txtResult.setText("No result available.");
            Toast.makeText(this, "Sorry!", Toast.LENGTH_SHORT).show();
        }
    }

    //For Back Button Functionality:
    @Override
    public void onBackPressed() {
        // Start the desired activity instead of going back to the previous one
        super.onBackPressed();
        Intent intent = new Intent(ResultFor2Activity.this, OptionActivity.class);
        startActivity(intent);
        finish();
    }

    private void showTable(){
        resultFor2Binding.output1.setText(String.valueOf(kmapValues[0]));
        resultFor2Binding.output2.setText(String.valueOf(kmapValues[1]));
        resultFor2Binding.output3.setText(String.valueOf(kmapValues[2]));
        resultFor2Binding.output4.setText(String.valueOf(kmapValues[3]));
    }
}