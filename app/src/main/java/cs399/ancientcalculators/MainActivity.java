package cs399.ancientcalculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // spinners
    Spinner mySpinner;
    // edit text
    EditText inNum1;
    EditText inNum2;
    // calculator object used for calculations

    Calculator calc;

    TextView answer; // answer block






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new Calculator();

        mySpinner = (Spinner) findViewById(R.id.Op); // the dropdown spinner

        inNum1 = (EditText) findViewById(R.id.num1); // the first number user inputs
        inNum2 = (EditText) findViewById(R.id.num2); // second number user inputs



        answer = (TextView) findViewById(R.id.ans); // the answer block





        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.operators));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Button go = (Button) findViewById(R.id.go);
        Button clear = (Button) findViewById(R.id.clear);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    calculateOp();


                } catch(Exception e) { e.printStackTrace(); }


            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearingAnswer();
            }
        });


    }

    // method that will do all the visuals and calculations
    private void calculateOp(){

        // textview for colums as well as
        TextView n0;
        TextView n1;
        TextView n2;
        TextView n3;
        TextView n4;
        TextView n5;
        TextView n6;







        // pointing the textview
        n0 = (TextView) findViewById(R.id.n0);
        n1 = (TextView) findViewById(R.id.n1);
        n2 = (TextView) findViewById(R.id.n2);
        n3 = (TextView) findViewById(R.id.n3);
        n4 = (TextView) findViewById(R.id.n4);
        n5 = (TextView) findViewById(R.id.n5);
        n6 = (TextView) findViewById(R.id.n6);





        // switches to show the bools
        Switch b0;
        Switch b1;
        Switch b2;
        Switch b3;
        Switch b4;
        Switch b5;
        Switch b6;


        // pointing the switches
        b0 = (Switch) findViewById(R.id.b0);
        b1 = (Switch) findViewById(R.id.b1);
        b2 = (Switch) findViewById(R.id.b2);
        b3 = (Switch) findViewById(R.id.b3);
        b4 = (Switch) findViewById(R.id.b4);
        b5 = (Switch) findViewById(R.id.b5);
        b6 = (Switch) findViewById(R.id.b6);

        // array of text view and switches

        TextView[] numAr = {n0,n1,n2,n3,n4,n5,n6};
        Switch[] boolAr = {b0,b1,b2,b3,b4,b5,b6};


        String toBinary;


        // getting the selcted item
        String operand = mySpinner.getSelectedItem().toString();
        // transforming the edit text to a double
        String num1Value = inNum1.getText().toString(); // num1
        double num1Final =Integer.parseInt(num1Value);
        double value = 0;

        String num2Value = inNum2.getText().toString(); // num2
        double num2Final =Double.parseDouble(num2Value);


        // if statement
        // value -> binary -> forloop to show binary in switch
        // num2 -> double it each time for num to show
        if (operand.equals("+")){
            value = calc.add(num1Final,num2Final);
            double valueDouble = num2Final; // var used to show in column 3 doubles
            toBinary = Integer.toBinaryString((int) value); // converting the value into a binary string
            toBinary = "0000000".substring(toBinary.length()) + toBinary; // padding into the 7 digit binary
            answer.setText("" + value);
            for (int i = 0; i<toBinary.length(); i++){
                if (boolAr[toBinary.length()-i-1].isChecked())
                    boolAr[toBinary.length()-i-1].toggle(); // used to clear out the switches

                if (toBinary.charAt(i) == '1'){
                    boolAr[toBinary.length()-i-1].toggle(); // telling java here bro this is where to open switch
                }
                numAr[i].setText("" + valueDouble); // concurrent variable is showing in columns
                valueDouble*=2; // doubling the value again

            }
        }

        else if (operand.equals("-")){
            value = calc.subtract(num1Final,num2Final);
            double valueDouble = num2Final;
            toBinary = Integer.toBinaryString((int) value);
            toBinary = "0000000".substring(toBinary.length()) + toBinary;
            answer.setText("" + value);
            for (int i = 0; i<toBinary.length(); i++){
                if (boolAr[toBinary.length()-i-1].isChecked())
                    boolAr[toBinary.length()-i-1].toggle();

                if (toBinary.charAt(i) == '1'){
                    boolAr[toBinary.length()-i-1].toggle();
                }
                numAr[i].setText("" + valueDouble);
                valueDouble*=2;

            }

        }

        else if (operand.equals("/")){
            value = calc.divide(num1Final,num2Final);
            double valueDouble = num2Final;
            toBinary = Integer.toBinaryString((int) value);
            toBinary = "0000000".substring(toBinary.length()) + toBinary;
            answer.setText("" + value);
            for (int i = 0; i<toBinary.length(); i++){
                if (boolAr[toBinary.length()-i-1].isChecked())
                    boolAr[toBinary.length()-i-1].toggle();

                if (toBinary.charAt(i) == '1'){
                    boolAr[toBinary.length()-i-1].toggle();
                }
                numAr[i].setText("" + valueDouble);
                valueDouble*=2;

            }
        }

        else if (operand.equals("*")){
            value = calc.multiply(num1Final, num2Final);
            double valueDouble = num2Final;
            toBinary = Integer.toBinaryString((int) value);
            toBinary = "0000000".substring(toBinary.length()) + toBinary;
            answer.setText("" + value);
            for (int i = 0; i<toBinary.length(); i++){
                if (toBinary.charAt(i) == '1')
                    boolAr[i].toggle();

            }
        }
        else {
            answer.setText(operand);
        }

    }

    private void clearingAnswer(){
        answer.setText("Clear!");


    }
    public static void main(String[] args){

        String toBinary = Integer.toBinaryString((int) 2+1);
        toBinary = "0000000".substring(toBinary.length()) + toBinary;
        System.out.println(toBinary);
        System.out.println(toBinary.length());

    }

    static class Calculator {
      //  Calculator(char op, double num1, double num2){}
        public double add(double num1, double num2){
            
            return num1+num2;
        }
        public double subtract(double num1, double num2){
            return num1-num2;
        }
        public int multiply(double num1, double num2){
            return (int) num1 * (int) num2;
        }
        public int divide(double num1, double num2){
            return (int) num1 / (int) num2;
        }

    }

}
