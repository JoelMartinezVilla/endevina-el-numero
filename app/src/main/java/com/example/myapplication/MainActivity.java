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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Random randomNumbers = new Random();
        int number = randomNumbers.nextInt(100)+1;
        final Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        TextView textViewTries = findViewById(R.id.textViewTries);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence numberText = String.valueOf(number);
                textViewNumber.setText(numberText);

                CharSequence textSuccess = "Lo has adivinado! :)";
                CharSequence textFailure = "No lo has adivinado! :(";
                int duration = Toast.LENGTH_SHORT;


                String guessText = String.valueOf(editText.getText());
                int guess = Integer.parseInt(guessText);

                if (guess == number){
                    Toast toast = Toast.makeText(MainActivity.this, textSuccess, duration);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, textFailure, duration);
                    toast.show();
                };


            }
        });
    }
}