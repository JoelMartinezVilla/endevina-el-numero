package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static int tries = 0;
    static Random randomNumbers = new Random();
    public static int number = randomNumbers.nextInt(100)+1;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        TextView textViewTries = findViewById(R.id.textViewTries);
        CharSequence numberText = String.valueOf(number);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tries++;

                CharSequence textSuccess = "Lo has adivinado! :)";
                CharSequence textFailureLower = "El número secreto es más pequeño! :(";
                CharSequence textFailureBigger = "El número secreto es más grande! :(";
                int duration = Toast.LENGTH_SHORT;


                String guessText = String.valueOf(editText.getText());
                int guess = Integer.parseInt(guessText);

                if (guess == number){
                    Toast toast = Toast.makeText(MainActivity.this, textSuccess, duration);
                    toast.show();
                    number = randomNumbers.nextInt(100)+1;
                    tries = 0;
                    CharSequence numberText = String.valueOf(number);

                }else if(guess<number){
                    Toast toast = Toast.makeText(MainActivity.this, textFailureBigger, duration);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, textFailureLower, duration);
                    toast.show();
                };
                textViewTries.setText("Tries: "+tries);


            }
        });

    }
}