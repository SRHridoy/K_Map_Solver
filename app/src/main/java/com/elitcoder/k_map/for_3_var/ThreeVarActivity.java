package com.elitcoder.k_map.for_3_var;

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
import com.elitcoder.k_map.R;
import com.elitcoder.k_map.databinding.ActivityThreeVarBinding;

public class ThreeVarActivity extends AppCompatActivity {

    public int[][] kmapValues = new int[2][4];
    ActivityThreeVarBinding threeVarBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Binding:
        threeVarBinding = ActivityThreeVarBinding.inflate(getLayoutInflater());
        View view = threeVarBinding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Common Listener:
        makingCommonListener();

        //SimplifyButton:
        simplifyButtonPressed();
    }
    void makingCommonListener(){
        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                Button btn_txt = (Button) v;
                String txt =  ((Button) v).getText().toString();
                //Checking and marking:
                switch (txt) {
                    case "A'B'C'":
                        kmapValues[0][0] = 1;
                        break;
                    case "A'B'C":
                        kmapValues[0][1] = 1;
                        break;
                    case "A'BC":
                        kmapValues[0][2] = 1;
                        break;
                    case "A'BC'":
                        kmapValues[0][3] = 1;
                        break;
                    case "AB'C'":
                        kmapValues[1][0] = 1;
                        break;
                    case "AB'C":
                        kmapValues[1][1] = 1;
                        break;
                    case "ABC":
                        kmapValues[1][2] = 1;
                        break;
                    case "ABC'":
                        kmapValues[1][3] = 1;
                        break;
                    default:
                        Toast.makeText(ThreeVarActivity.this, "Error Getting Input!", Toast.LENGTH_SHORT).show();
                }
            }
        };
        //Setting Common Listener:
        threeVarBinding.btn000.setOnClickListener(commonClickListener);
        threeVarBinding.btn001.setOnClickListener(commonClickListener);
        threeVarBinding.btn010.setOnClickListener(commonClickListener);
        threeVarBinding.btn011.setOnClickListener(commonClickListener);
        threeVarBinding.btn100.setOnClickListener(commonClickListener);
        threeVarBinding.btn101.setOnClickListener(commonClickListener);
        threeVarBinding.btn110.setOnClickListener(commonClickListener);
        threeVarBinding.btn111.setOnClickListener(commonClickListener);
    }


    void simplifyButtonPressed(){
        threeVarBinding.btnSimplify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Result test:
                //Creating logic class instance for getting and calling the result func:
                LogicForThree logicForThree = new LogicForThree(kmapValues);
                String result = logicForThree.simplifyKmap();


                //Successful:
                Intent intent = new Intent(getApplicationContext(), ResultFor3Activity.class);
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
        Intent intent = new Intent(ThreeVarActivity.this, OptionActivity.class);
        startActivity(intent);
        finish();
    }
}