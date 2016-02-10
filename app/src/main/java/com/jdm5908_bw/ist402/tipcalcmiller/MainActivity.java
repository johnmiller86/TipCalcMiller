package com.jdm5908_bw.ist402.tipcalcmiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);

        SeekBar sB = (SeekBar) findViewById(R.id.percentageSeekBar);
        final TextView perTV = (TextView) findViewById(R.id.percentageTextView);
        sB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                perTV.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
