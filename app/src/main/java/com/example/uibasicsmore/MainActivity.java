package com.example.uibasicsmore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkHarry, chkMatrix, chkJoker;
    private RadioGroup rgroupMarital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // change the theme randomly based on th uptime
        if (SystemClock.uptimeMillis() % 2 == 0 )
            setTheme(R.style.Theme_UIBasicsMore_Lavender);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkHarry = findViewById(R.id.chkHarry);
        chkMatrix = findViewById(R.id.chkMatrix);
        chkJoker = findViewById(R.id.chkJoker);
        rgroupMarital = findViewById(R.id.rgroupMarital);

        chkHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Harry Potter!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Display the Toast message at the beginning
        int radioID = rgroupMarital.getCheckedRadioButtonId();
        switch (radioID) {
            case R.id.rbtnMarried:
                Toast.makeText(MainActivity.this, "You have selected Married!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbtnSingle:
                Toast.makeText(MainActivity.this, "You have selected Single!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbtnCommonLaw:
                Toast.makeText(MainActivity.this, "You have selected Common Law!", Toast.LENGTH_SHORT).show();
                break;
        }

        rgroupMarital.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtnMarried:
                        Toast.makeText(MainActivity.this, "You have selected Married!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnSingle:
                        Toast.makeText(MainActivity.this, "You have selected Single!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnCommonLaw:
                        Toast.makeText(MainActivity.this, "You have selected Common Law!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    public void btnStartProgressingOnClick(View view) {
        ProgressBar pBar1 = findViewById(R.id.pbar1);
        pBar1.setProgress(0);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    pBar1.incrementProgressBy(1);
                    SystemClock.sleep(100);
                }
            }
        });
        thread.start();
    }


}