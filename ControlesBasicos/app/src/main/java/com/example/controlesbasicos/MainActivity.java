package com.example.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    Switch swt1;
    Switch swt2;
    ToggleButton tgg1;
    ToggleButton tgg2;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        swt1 = (Switch) findViewById(R.id.swt1);
        swt2 = (Switch) findViewById(R.id.swt2);
        tgg1 = (ToggleButton) findViewById(R.id.tgg1);
        tgg2 = (ToggleButton) findViewById(R.id.tgg2);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);

        img1.setImageResource(R.drawable.camara);
        img3.setImageResource(R.drawable.camara);

        swt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swt1.isChecked() == true){
                    img1.setVisibility(View.VISIBLE);
                }else{
                    img1.setVisibility(View.INVISIBLE);
                }
            }
        });
        swt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swt2.isChecked() == true){
                    img2.setImageResource(R.drawable.bombillaencendida);
                }else{
                    img2.setImageResource(R.drawable.bombillaapagada);
                }
            }
        });
        tgg1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tgg1.isChecked() == true){
                    img3.setVisibility(View.VISIBLE);
                }else{
                    img3.setVisibility(View.INVISIBLE);
                }
            }
        });
        tgg2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tgg2.isChecked() == true){
                    img4.setImageResource(R.drawable.bombillaencendida);
                }else{
                    img4.setImageResource(R.drawable.bombillaapagada);
                }
            }
        });

    }
}

