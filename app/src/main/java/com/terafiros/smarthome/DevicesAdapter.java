package com.terafiros.smarthome;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Eduardo Oliveira on 26/04/2018.
 */

public class DevicesAdapter extends BaseAdapter {

    private List<Device> deviceList;
    private Activity activity;

    public DevicesAdapter(@NonNull Activity activity, @NonNull List<Device> objects) {
        this.deviceList = objects;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return deviceList.size();
    }

    @Override
    public Object getItem(int position) {
        return deviceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.devices_adapter_layout, parent, false);
        Device device = deviceList.get(position);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);
        TextView deviceName = (TextView) view.findViewById(R.id.device_name);
        Switch deviceState = (Switch) view.findViewById(R.id.device_state);

        deviceName.setText(device.getName());
        deviceState.setChecked(device.isState());

        return view;

    }
}
