package com.elitcoder.k_map.for_2_var;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.k_map.OptionActivity;
import com.elitcoder.k_map.databinding.ActivityTwoVarBinding;
import com.elitcoder.k_map.R;
import com.elitcoder.k_map.for_3_var.ResultFor3Activity;

public class TwoVarActivity extends AppCompatActivity {
    ActivityTwoVarBinding twoVarBinding;
    private  int[] kmapValues = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Bindig:
        twoVarBinding = ActivityTwoVarBinding.inflate(getLayoutInflater());
        View view = twoVarBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Common Listener:
        makeCommonListener();
        //Simplify Button Implemented:
        simplifyButtonPressed();
    }
    void makeCommonListener(){
        View.OnClickListener commonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Button btn_txt = (Button) v;
                String txt =  (btn_txt).getText().toString();
                switch (txt) {
                    case "A'B'":
                        kmapValues[0] = 1;
                        break;
                    case "A'B":
                        kmapValues[1] = 1;
                        break;
                    case "AB'":
                        kmapValues[2] = 1;
                        break;
                    case "AB":
                        kmapValues[3] = 1;
                        break;
                    default:
                        Toast.makeText(TwoVarActivity.this, "Error Getting Input!", Toast.LENGTH_SHORT).show();
                }
            }
        };
        //Setting Common Listener:
        twoVarBinding.btn00.setOnClickListener(commonListener);
        twoVarBinding.btn01.setOnClickListener(commonListener);
        twoVarBinding.btn10.setOnClickListener(commonListener);
        twoVarBinding.btn11.setOnClickListener(commonListener);
    }

    void simplifyButtonPressed(){
        twoVarBinding.btnSimplify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Result test:
                //Creating logic class instance for getting and calling the result func:
                LogicForTwo logicForTwo = new LogicForTwo(kmapValues);
                String result = logicForTwo.simplifyKmap();


                //Successful:
                Intent intent = new Intent(getApplicationContext(), ResultFor2Activity.class);

                //Sending Result to ResultActivity:
                intent.putExtra("simplified_result", result);
                intent.putExtra("kmap_values", kmapValues);
                startActivity(intent);
                finish();
            }
        });
    }
    //For Back Button Functionality:
    @Override
    public void onBackPressed() {
        // Start the desired activity instead of going back to the previous one
        super.onBackPressed();
        Intent intent = new Intent(TwoVarActivity.this, OptionActivity.class);
        startActivity(intent);
        finish();
    }
}