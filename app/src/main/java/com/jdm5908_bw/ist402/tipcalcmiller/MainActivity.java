package com.jdm5908_bw.ist402.tipcalcmiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    // UI Objects
    private SeekBar percentageSeekBar;
    private EditText billEditText, tip10EditText, tip15EditText, tip20EditText, total10EditText, total15EditText, total20EditText, tipAmountEditText, totalAmountEditText;
    private TextView percentageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        setUIReferences();
        billEditText.addTextChangedListener(textWatcher);
        percentageSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    private void setUIReferences() {
        billEditText = (EditText) findViewById(R.id.billEditText);
        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
        total10EditText = (EditText) findViewById(R.id.total100EditText);
        total15EditText = (EditText) findViewById(R.id.total15EditText);
        total20EditText = (EditText) findViewById(R.id.total20EditText);
        tipAmountEditText = (EditText) findViewById(R.id.tipAmountEditText);
        totalAmountEditText = (EditText) findViewById(R.id.totalAmountEditText);
        percentageSeekBar = (SeekBar) findViewById(R.id.percentageSeekBar);
        percentageTextView = (TextView) findViewById(R.id.percentageTextView);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            percentageTextView.setText(String.valueOf(progress) + "%");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar){}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar){}
    };
}
