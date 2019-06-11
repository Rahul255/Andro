package com.example.userinput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void increment(View view) {
        quantity++;
        display(quantity);
    }
    public void decrement(View view) {
        quantity--;
        display(quantity);
    }
    public void submitOrder(View view) {
        int price=quantity*5;
        String priceMessage=price + " dollars for " + quantity + " cups of coffee... Pay up!";
        priceMessage=priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private  void displayPrice( int number){
        TextView priceTextView=(TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private  void displayMessage(String message){
        TextView priceTextView=(TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
