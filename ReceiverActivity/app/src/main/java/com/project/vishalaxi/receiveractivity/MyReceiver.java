package com.project.vishalaxi.receiveractivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Intent i;
        if(intent.getAction().equals("com.app.SendBChicago")){
               i = new Intent(context.getApplicationContext(), ChicagoViewerActivity.class);
        }else{
               i = new Intent(context.getApplicationContext(), IndianapolisViewerActivity.class);
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

}
