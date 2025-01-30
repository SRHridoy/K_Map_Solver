package com.elitcoder.k_map.for_3_var;

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
import com.elitcoder.k_map.databinding.ActivityResultFor3Binding;

public class ResultFor3Activity extends AppCompatActivity {
    ActivityResultFor3Binding resultFor3Binding;
    private int[][] kmapValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Bindig:
        resultFor3Binding = ActivityResultFor3Binding.inflate(getLayoutInflater());
        View view = resultFor3Binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the simplified K-map result string:
        String result = getIntent().getStringExtra("simplified_result");
        kmapValues = (int[][]) getIntent().getSerializableExtra("kmap_values");

        //Working on Truth Table:
        showTable();

        //Show Result:
        if (result != null) {
            resultFor3Binding.txtResult.setText("The Simplified function is: " + result);
            Toast.makeText(this, "Successfully Simplified!", Toast.LENGTH_SHORT).show();
        } else {
            resultFor3Binding.txtResult.setText("No result available.");
            Toast.makeText(this, "Sorry!", Toast.LENGTH_SHORT).show();
        }

    }
    //For Back Button Functionality:
    @Override
    public void onBackPressed() {
        // Start the desired activity instead of going back to the previous one
        super.onBackPressed();
        Intent intent = new Intent(ResultFor3Activity.this, OptionActivity.class);
        startActivity(intent);
        finish();
    }

    private void showTable(){
        resultFor3Binding.output1.setText(String.valueOf(kmapValues[0][0]));
        resultFor3Binding.output2.setText(String.valueOf(kmapValues[0][1]));
        resultFor3Binding.output3.setText(String.valueOf(kmapValues[0][2]));
        resultFor3Binding.output4.setText(String.valueOf(kmapValues[0][3]));
        resultFor3Binding.output5.setText(String.valueOf(kmapValues[1][0]));
        resultFor3Binding.output6.setText(String.valueOf(kmapValues[1][1]));
        resultFor3Binding.output7.setText(String.valueOf(kmapValues[1][2]));
        resultFor3Binding.output8.setText(String.valueOf(kmapValues[1][3]));
    }
}