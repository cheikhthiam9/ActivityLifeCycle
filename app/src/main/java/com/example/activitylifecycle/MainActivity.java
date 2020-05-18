package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showGuess;
    private EditText enterGuess;

    //Using this REQUEST_CODE for onActivityResult method
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showGuess = findViewById(R.id.button_guess);
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using the getText() method to collect the data entered
                // by the user and storing it in a variable
                //Calling toString () method to convert it in a string (if it was an int for ex)
                // Using trim() to remove the trash around the string
                String guess = enterGuess.getText().toString().trim();

                if (!guess.isEmpty()) {
                    //Intent class is allowing us to do many things
                    //Including opening  a new activity like below
                    //Param are Actual activity,Desired Activity
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class );

                    //Using putExtra overloaded method to pass values  while going to another activity
                    //Takes a key (a string) and value (any type)
                    //USEFUL WHEN YOU ONLY PASSING ONE VALUE
                    intent.putExtra("guess", guess);

                    //
                    startActivityForResult(intent, REQUEST_CODE);

                } else {
                    Toast.makeText(MainActivity.this, "No entry. Enter a Guess", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    //Using onActivityResult to retrieve data that may be used in other activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this,message , Toast.LENGTH_SHORT).show();

            }

        }
    }
}
