package com.example.assignment3;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;

public class DataStored extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_stored);

        // Retrieve the intent and the passed data
        String workoutName = getIntent().getStringExtra("WORKOUT_NAME");
        String workoutDuration = getIntent().getStringExtra("WORKOUT_DURATION");
        String workoutCalories = getIntent().getStringExtra("WORKOUT_CALORIES");

        // Find the TextView to display the data (add this to your activity_data_stored.xml)
        TextView dataTextView = new TextView(this);
        String displayText = "Workout Name: " + workoutName + "\n" +
                "Duration: " + workoutDuration + "\n" +
                "Calories: " + workoutCalories;

        dataTextView.setText(displayText);
        dataTextView.setTextSize(18);
        dataTextView.setPadding(16, 16, 16, 16);

        // Add the TextView to the layout (ensure you have a LinearLayout or similar in activity_data_stored.xml)
        LinearLayout layout = findViewById(R.id.main);
        layout.addView(dataTextView);
    }
}
