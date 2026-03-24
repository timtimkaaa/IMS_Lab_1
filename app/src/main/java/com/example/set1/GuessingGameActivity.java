package com.example.set1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//Tsimafei Mardashou, 46011, Lab 3

public class GuessingGameActivity extends AppCompatActivity {

    EditText guessInput;
    Button guessButton;
    TextView messageText, attemptCounterText;
    int rightAnswer;
    int attemptCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guessing_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rightAnswer = (int) Math.ceil(Math.random() * 10);

        guessInput = findViewById(R.id.guessInput);
        guessButton = findViewById(R.id.guessButton);
        messageText = findViewById(R.id.messageText);
        attemptCounterText = findViewById(R.id.attemptCounterText);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = guessInput.getText().toString().trim();
                if (input.isEmpty()) {
                    messageText.setText("Enter a number");
                    return;
                }

                int guess = 0;

                try {
                    guess = Integer.parseInt(input);
                    if (guess > 10) throw new Exception();

                    attemptCounter++;
                    attemptCounterText.setText("Attempts:" + attemptCounter);

                    if (guess == rightAnswer) {
                        if (attemptCounter == 2) {
                            messageText.setText("You won!");
                            attemptCounter = 0;
                            rightAnswer = (int) Math.ceil(Math.random() * 10);
                        } else {
                            messageText.setText("Correct, but not on the 2nd attempt. Try again.");
                            attemptCounter = 0;
                            rightAnswer = (int) Math.ceil(Math.random() * 10);
                        }
                    } else {
                        messageText.setText("Wrong! Try again.");
                    }
                } catch (Exception e) {
                    messageText.setText("Wrong input! Insert a number 1-10");
                }
            }
        });
    }

}