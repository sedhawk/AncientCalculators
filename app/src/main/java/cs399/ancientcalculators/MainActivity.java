package cs399.ancientcalculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner;
    EditText inNum1;
    EditText inNum2;
    TextView answer;
    Calculator calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new Calculator();

        mySpinner = (Spinner) findViewById(R.id.Op); // the dropdown spinner
        inNum1 = (EditText) findViewById(R.id.num1); // the first number user inputs
        inNum2 = (EditText) findViewById(R.id.num2); // second number user inputs
        answer = (TextView) findViewById(R.id.ans); // the answer block


        // double num1Value = Double.valueOf(inNum1.getText().toString());
        // transforming the edit text to a double
        //String num1Value = inNum1.getText().toString(); // num1
        //int num1Final =Integer.parseInt(num1Value);

       // String num2Value = inNum1.getText().toString(); // num2
  //      final Double num2Final =Double.parseDouble(num2Value);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.operators));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Button go = (Button) findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    calculateOp();


                } catch(Exception e) { e.printStackTrace(); }


            }
        });

    }

    private void calculateOp(){
        // transforming the edit text to a double
        String num1Value = inNum1.getText().toString(); // num1
        double num1Final =Integer.parseInt(num1Value);
        double value = 0;

        String num2Value = inNum1.getText().toString(); // num2
        double num2Final =Double.parseDouble(num2Value);
        if (mySpinner.getSelectedItem().toString() == "+"){
            value = calc.add(num1Final,num2Final);
            answer.setText("" + value);
        }

        else if (mySpinner.getSelectedItem().toString() == "-"){
            value = calc.divide(num1Final,num2Final);
            answer.setText("" + value);
        }

        else if (mySpinner.getSelectedItem().toString() == "*"){
            value = calc.multiply(num1Final, num2Final);
            answer.setText("" + value);
        }




    }
    public static void main(String[] args){


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
