package cs399.ancientcalculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
