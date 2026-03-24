package com.example.set1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//Tsimafei Mardashou, 46011, lab 1,2. See GuessingGameActivity for lab 3

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button buttonWitaj;
    Button gameButton;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.textInput);
        buttonWitaj = findViewById(R.id.welcomeButton);
        textResult = findViewById(R.id.welcomeText);
        gameButton = findViewById(R.id.gameButton);


        buttonWitaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();

                if (!name.isEmpty()) {
                    textResult.setText("Witaj " + name);
                } else {
                    textResult.setText("Przedstaw się.");
                }

            }
        });

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuessingGameActivity.class);
                startActivity(intent);
            }
        });
    }

}