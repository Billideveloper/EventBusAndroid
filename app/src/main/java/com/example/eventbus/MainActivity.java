package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private Button acnbtn;
    private TextView textresult;
    private EventBus evntBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registering a event bus for this activity
        evntBus.register(this);

        // registering the objects
        acnbtn = (Button) findViewById(R.id.nextBtn);
        textresult = (TextView) findViewById(R.id.resultText);
    }

    // called from another activity
    public void onEvent(customBackgroundEvent event) {
        // whenever customBackgroundEvent is called from another actvity and event is posted it will come here
        Log.d("Called ", "the event bus called");
        System.out.println("Called the event Bus");
        Toast.makeText(this, "Posted", Toast.LENGTH_LONG).show();
        textresult.setText(event.getMsg());
    }

    
    // btn on click listners
    public void nextBtnClicked(View view) {
        Intent activiityIntent = new Intent(this, performtask.class);
        startActivity(activiityIntent);
    }
}