package com.martinscastanho.marco.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer choiceNumber;

    public void generateRandomNumber(){
        Random r = new Random();
        choiceNumber = r.nextInt(21 - 1) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

    public void guess(View view) {
        EditText guessEditText = findViewById(R.id.guessEditText);
        Integer guess = Integer.parseInt(guessEditText.getText().toString());
        String message = "";
        if(guess.intValue() == choiceNumber){
            message = "You got it! Try again!";
            generateRandomNumber();
        }
        else if(guess < choiceNumber){
            message = "Higher!";
        }
        else if(guess > choiceNumber){
            message = "Lower!";
        }
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
    }
}
