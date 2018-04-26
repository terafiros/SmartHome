package com.terafiros.smarthome;

/**
 * Created by Eduardo Oliveira on 26/04/2018.
 */

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDeviceActivity extends AppCompatActivity {

    private TextInputEditText nameEditText;
    private TextInputEditText serialNumberEditText;
    private Button addButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        nameEditText = (TextInputEditText) findViewById(R.id.name_edit_text);
        serialNumberEditText = (TextInputEditText) findViewById(R.id.serial_number_edit_text);

    }

    public void addDevice(View view){
        Device device = new Device(serialNumberEditText.getText().toString(), nameEditText.getText().toString());
        Intent it = new Intent();
        it.putExtra("device", device);
        exit(it);
    }

    public void cancel(View v){
        exit(null);
    }

    private void exit(Intent intent) {
        if(intent == null)
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        else {
            intent.setClass(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

}
