package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TIpCalculatorActivity extends AppCompatActivity {

    private EditText BillAmount;
    private EditText PartySize;
    private TextView fifteenVal;
    private TextView twentyVal;
    private TextView twentyfiveVal;
    private TextView fifteenAmount;
    private TextView twentyAmount;
    private TextView twentyfiveAmount;
    private Button calculateTips;

    double tip15;
    double tip20;
    double tip25;
    double finalamount15;
    double finalamount20;
    double finalamount25;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        BillAmount = findViewById(R.id.checkAmountValue);
        PartySize = findViewById(R.id.partySizeValue);
        fifteenVal = findViewById(R.id.fifteenPercentTipValue);
        twentyVal = findViewById(R.id.twentyPercentTipValue);
        twentyfiveVal = findViewById(R.id.twentyfivePercentTipValue);
        fifteenAmount = findViewById(R.id.fifteenPercentTotalValue);
        twentyAmount = findViewById(R.id.twentyPercentTotalValue);
        twentyfiveAmount = findViewById(R.id.twentyfivePercentTotalValue);
        calculateTips = findViewById(R.id.buttonCompute);


    }




    public void calculateTips(View view) {



        if (view.getId() == calculateTips.getId()) {

            if ((BillAmount.getText().toString().isEmpty()) || (PartySize.getText().toString().isEmpty())) {
                Toast.makeText(TIpCalculatorActivity.this, "Empty or Incorrect Value(s)!", Toast.LENGTH_SHORT).show();
            }
            else {
                int Bill = Integer.valueOf(BillAmount.getText().toString());
                int Party = Integer.valueOf(PartySize.getText().toString());

                if (Bill < 0 || Party < 0) {
                    Toast.makeText(TIpCalculatorActivity.this, "Empty or Incorrect Value(s)!", Toast.LENGTH_SHORT).show();

                } else {

                    finalamount15 = Integer.parseInt(BillAmount.getText().toString());
                    finalamount20 = Integer.parseInt(BillAmount.getText().toString());
                    finalamount25 = Integer.parseInt(BillAmount.getText().toString());


                    tip15 = ((finalamount15 / Integer.parseInt(PartySize.getText().toString())) * .15);
                    finalamount15 = Math.round(tip15) + (finalamount15 / Integer.parseInt(PartySize.getText().toString()));
                    fifteenVal.setText("$" + Math.round(tip15));
                    fifteenAmount.setText("$" + Math.round(finalamount15));

                    tip20 = ((finalamount20 / Integer.parseInt(PartySize.getText().toString())) * .20);
                    finalamount20 = Math.round(tip20) + (finalamount20 / Integer.parseInt(PartySize.getText().toString()));
                    twentyVal.setText("$" + Math.round(tip20));
                    twentyAmount.setText("$" + Math.round(finalamount20));

                    tip25 = ((finalamount25 / Integer.parseInt(PartySize.getText().toString())) * .25);
                    finalamount25 = tip25 + (finalamount25 / Integer.parseInt(PartySize.getText().toString()));
                    twentyfiveVal.setText("$" + Math.round(tip25));
                    twentyfiveAmount.setText("$" + Math.round(finalamount25));

                }
            }
        }
    }
}


