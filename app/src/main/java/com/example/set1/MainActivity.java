package com.example.set1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.set1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button buttonWitaj;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.textInput);
        buttonWitaj = findViewById(R.id.welcomeButton);
        textResult = findViewById(R.id.welcomeText);

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
    }

}