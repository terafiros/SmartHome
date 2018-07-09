package com.terafiros.smarthome;

/**
 * Created by Eduardo Oliveira on 26/04/2018.
 */

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addButton;
    private ListView devices;
    private DevicesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initAddButton();
        initDeviceList();
    }

    private void initDeviceList() {
        devices = (ListView) findViewById(R.id.devices);
        devices.setEmptyView(findViewById(R.id.empty_view));

        adapter = new DevicesAdapter(this, all());
        devices.setAdapter(adapter);
    }

    private List<Device> all() {
        ArrayList list =  new ArrayList<Device>();
        Device device = getIntent().getParcelableExtra("device");
        if (device != null)
            list.add(device);

        list.add(new Device("1", "primeiro"));
        list.add(new Device("2", "segundo"));
        list.add(new Device("3", "terceiro"));
        list.add(new Device("4", "quarto"));
        list.add(new Device("5", "quinto"));
        list.add(new Device("6", "sexto"));

        return list;
    }

    private void initAddButton() {
        addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddDeviceActivity.class));
            }
        });

    }
}