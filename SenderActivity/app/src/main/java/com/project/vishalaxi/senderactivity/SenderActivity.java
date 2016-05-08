package com.project.vishalaxi.senderactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class SenderActivity extends AppCompatActivity {
    private Button sendB1,sendB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        sendB1=(Button)findViewById(R.id.button_c);
        sendB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle click
                Intent intent = new Intent();
                intent.setAction("com.app.SendBChicago");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
                Toast.makeText(SenderActivity.this, "Sending Broadcast for Chicago...", Toast.LENGTH_SHORT).show();
            }
        });

        sendB2=(Button)findViewById(R.id.button_i);
        sendB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle click
                Intent intent = new Intent();
                intent.setAction("com.app.SendBIndianaPolis");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
                Toast.makeText(SenderActivity.this,"Sending Broadcast for IndianaPolis...",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
