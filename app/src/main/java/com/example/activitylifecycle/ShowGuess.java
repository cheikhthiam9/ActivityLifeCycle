package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
private TextView showGuessTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        // Bundle is a class that allows us to put all sorts of things inside of it
        Bundle extra = getIntent().getExtras();


        showGuessTextView = findViewById(R.id.receive_text_view);


//        if (extra != null ) {
//            showGuessTextView.setText(extra.getString("guess"));
//        }

//        Using getIntent  and getStringExtra method to get the value of the key we want to access
//        Previously declared in the other activity
//        Storing it into a string
       String value =  getIntent().getStringExtra("guess");
       //Checking if the value attached to the key is not null
       if (getIntent().getStringExtra("guess")!=null){
           showGuessTextView.setText(value);
       }


       showGuessTextView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = getIntent();
               intent.putExtra("message_back", "From Second Activity");
               setResult(RESULT_OK, intent);
               finish();
           }
       });


    }



}
