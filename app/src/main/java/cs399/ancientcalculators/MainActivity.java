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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calculator calc = new Calculator();

        final Spinner mySpinner = (Spinner) findViewById(R.id.Operators); // the dropdown spinner
        final EditText inNum1 = (EditText) findViewById(R.id.num1); // the first number user inputs
        final EditText inNum2 = (EditText) findViewById(R.id.num2); // second number user inputs
        final TextView answer = (TextView) findViewById(R.id.ans); // the answer block

/*
        // transforming the edit text to a double
        String num1Value = inNum1.getText().toString(); // num1
        final Double num1Final =Double.parseDouble(num1Value);

        String num2Value = inNum1.getText().toString(); // num2
        final Double num2Final =Double.parseDouble(num2Value);
*/

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.operators));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Button go = (Button) findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    answer.setText("Hello");


                } catch(Exception e) { e.printStackTrace(); }


            }
        });



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
