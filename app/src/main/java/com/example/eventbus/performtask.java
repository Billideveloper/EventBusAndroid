package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class performtask extends AppCompatActivity {

    private Button acnbtn;
    private EditText textresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performtask);
        // registering the objects
        acnbtn = (Button) findViewById(R.id.nextBtn);
        textresult = (EditText) findViewById(R.id.resultText);
    }

    // whenever back Btn Clicked
    public void backBtnClicked(View view) {
        // dismiss the activity
        String resulttxt = textresult.getText().toString();
        // calling the registered class
        customBackgroundEvent newevent = new customBackgroundEvent();
        newevent.setMsg(resulttxt);
        // posting the event - it will go to mainactivity on method onEvnt to update the result
        EventBus.getDefault().post(newevent);
        finish();
    }

}