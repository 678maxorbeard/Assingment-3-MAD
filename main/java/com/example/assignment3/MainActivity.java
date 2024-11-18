package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.workoutName)).getText().toString();
            String duration = ((EditText) findViewById(R.id.workoutDuration)).getText().toString();
            String calories = ((EditText) findViewById(R.id.workoutCalories)).getText().toString();

            // Show a toast message
            Toast.makeText(MainActivity.this, "Workout Saved Successfully", Toast.LENGTH_SHORT).show();

            // Create an intent to start DataStored activity
            Intent intent = new Intent(MainActivity.this, DataStored.class);
            // Put the workout data in the intent extras
            intent.putExtra("WORKOUT_NAME", name);
            intent.putExtra("WORKOUT_DURATION", duration);
            intent.putExtra("WORKOUT_CALORIES", calories);
            startActivity(intent);
        });
    }
}
