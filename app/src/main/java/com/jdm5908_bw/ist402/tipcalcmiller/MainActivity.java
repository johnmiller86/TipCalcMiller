package com.jdm5908_bw.ist402.tipcalcmiller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity{

    // Bundle Constants
    private static final String BILL_TOTAL = "BILL_TOTAL";
    private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";

    // UI Objects
    private SeekBar percentageSeekBar;
    private EditText billEditText, tip10EditText, tip15EditText, tip20EditText, total10EditText, total15EditText, total20EditText, tipAmountEditText, totalAmountEditText;
    private TextView percentageTextView;

    // Formatter
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);

        // Setting UI references
        setUIReferences();

        // Resuming
        if(savedInstanceState != null){
            billEditText.setText(savedInstanceState.getString(BILL_TOTAL));
            percentageSeekBar.setProgress(savedInstanceState.getInt(CUSTOM_PERCENT));
        }

        // Adding listeners
        billEditText.addTextChangedListener(textWatcher);
        percentageSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    /**
     * Sets all references for UI objects.
     */
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

    /**'
     * Listener for the bill EditText.
     */
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            performCalculations();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**
     * Listener for the SeekBar.
     */
    private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            percentageTextView.setText(String.valueOf(progress) + "%");
            performCalculations();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar){}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar){}
    };

    /**
     * Performs all calculations and sets all EditText text properties.
     */
    private void performCalculations(){

        if (billEditText.getText().toString().equals("")) {

            clearUI();
        }
        else{

            // Getting selections
            Double value = Double.parseDouble(billEditText.getText().toString());
            int percent = percentageSeekBar.getProgress();

            // Calculating
            tip10EditText.setText(String.valueOf(numberFormat.format(value * .1)));
            tip15EditText.setText(String.valueOf(numberFormat.format(value * .15)));
            tip20EditText.setText(String.valueOf(numberFormat.format(value * .2)));
            total10EditText.setText(String.valueOf(numberFormat.format(value * 1.1)));
            total15EditText.setText(String.valueOf(numberFormat.format(value * 1.15)));
            total20EditText.setText(String.valueOf(numberFormat.format(value * 1.2)));
            tipAmountEditText.setText(String.valueOf(numberFormat.format(value * (percent / 100.0))));
            totalAmountEditText.setText(String.valueOf(numberFormat.format(value * (1 + percent / 100.0))));
        }
    }

    private void clearUI(){
        tip10EditText.setText(R.string.zero);
        tip15EditText.setText(R.string.zero);
        tip20EditText.setText(R.string.zero);
        total10EditText.setText(R.string.zero);
        total15EditText.setText(R.string.zero);
        total20EditText.setText(R.string.zero);
        tipAmountEditText.setText(R.string.zero);
        totalAmountEditText.setText(R.string.zero);
    }
}
