package com.elitcoder.k_map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.k_map.databinding.ActivityOptionBinding;
import com.elitcoder.k_map.for_2_var.ResultFor2Activity;
import com.elitcoder.k_map.for_2_var.TwoVarActivity;
import com.elitcoder.k_map.for_3_var.ThreeVarActivity;

public class OptionActivity extends AppCompatActivity {
    ActivityOptionBinding optionBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        optionBinding = ActivityOptionBinding.inflate(getLayoutInflater());
        View view = optionBinding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        //Go to var 2 Activity:
        goToVar2();

        //Go to Var-3 Activity:
        goToVarVar3();


        //Future Work On Var-4:

    }

    //Function for Var3 Intent:
    void goToVarVar3(){
        optionBinding.btn3Var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, ThreeVarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //Function for var2 Intent:
    void goToVar2(){
        optionBinding.btn2Var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, TwoVarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}