package com.example.calcjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", previousCalculation.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        previousCalculation.setText(savedInstanceState.getString("key"));
    }

    private void updateText ( String strToAdd ) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }
    public void zeroBTNPush (View view ) {
        updateText (getResources().getString(R.string.zeroText)) ;
    }
    public void oneBTNPush (View view ) {
        updateText (getResources().getString(R.string.oneText)) ;
    }
    public void twoBTNPush (View view ) {
        updateText (getResources().getString(R.string.twoText)) ;
    }
    public void threeBTNPush (View view ) {
        updateText (getResources().getString(R.string.threeText)) ;
    }
    public void fourBTNPush (View view ) {
        updateText (getResources().getString(R.string.fourText)) ;
    }
    public void fiveBTNPush (View view ) {
        updateText (getResources().getString(R.string.fiveText)) ;
    }
    public void sixBTNPush (View view ) {
        updateText (getResources().getString(R.string.sixText)) ;
    }
    public void sevenBTNPush (View view ) {
        updateText (getResources().getString(R.string.sevenText)) ;
    }
    public void eightBTNPush (View view ) {
        updateText (getResources().getString(R.string.eightText)) ;
    }
    public void nineBTNPush (View view ) {
        updateText (getResources().getString(R.string.nineText)) ;
    }
    public void clearBTNPush (View view ) {
        display.setText("");
        previousCalculation.setText("");
    }
    public void parenthesesOpenBTNPush (View view ) {
        updateText (getResources().getString(R.string.parenthesesOpenText)) ;
    }
    public void parenthesesCloseBTNPush (View view ) {
        updateText (getResources().getString(R.string.parenthesesCloseText)) ;
    }
    public void divideBTNPush (View view ) {
        updateText (getResources().getString(R.string.divideText)) ;
    }
    public void multiplyBTNPush (View view ) {
        updateText (getResources().getString(R.string.multiplyText)) ;
    }
    public void addBTNPush (View view ) {
        updateText (getResources().getString(R.string.addText)) ;
    }
    public void subtractBTNPush (View view ) {
        updateText (getResources().getString(R.string.subtractText)) ;
    }
    public void decimalBTNPush (View view ) {
        updateText (getResources().getString(R.string.decimalText)) ;
    }
    public void equalsBTNPush (View view ) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        Expression exp = new Expression(userExp);
        double value = exp.calculate();
        String result = value % 2 != 1 && value % 2 != 0 ?  String.format("%.3f",value) : String.valueOf(value);
        if(!result.equals("NaN")) {
            display.setText(result);
        }else{
            display.setText("Error");
        }
        display.setSelection(result.length());
    }
    public void backspaceBTNPush (View view ) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0 ) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos -1);
        }
    }
    public void trigsinBTNPush (View view ) {
        updateText("sin(") ;
    }
    public void trigcosBTNPush (View view ) {
        updateText("cos(") ;
    }
    public void trigtanBTNPush (View view ) {
        updateText("tan(") ;
    }
    public void trigAsinBTNPush (View view ) {
        updateText("arcsin(") ;
    }
    public void trigAcosBTNPush (View view ) {
        updateText("arccos(") ;
    }
    public void trigAtanBTNPush (View view ) {
        updateText ("arctan(") ;
    }
    public void logBTNPush (View view ) {
        updateText("log(") ;
    }
    public void lnBTNPush (View view ) {
        updateText("ln(") ;
    }
    public void squareBTNPush (View view ) {
        updateText("sqrt(") ;
    }
    public void expBTNPush (View view ) {
        updateText("e") ;
    }
    public void piBTNPush (View view ) {
        updateText("pi") ;
    }
    public void naturalBTNPush (View view ) {
        updateText("abs(") ;
    }
    public void x3BTNPush (View view ) {
        updateText("^(3)") ;
    }
    public void x2BTNPush (View view ) {
        updateText("^(2)") ;
    }
    public void xyBTNPush (View view ) {
        updateText("^(") ;
    }

}
