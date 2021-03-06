package com.terafiros.smarthome;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        final Device device = deviceList.get(position);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);
        TextView deviceName = (TextView) view.findViewById(R.id.device_name);
        Switch deviceState = (Switch) view.findViewById(R.id.device_state);



        deviceName.setText(device.getName());
        deviceState.setChecked(device.isState());
        deviceState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String adress = "http://192.168.0.11:8080/insert/ON/" + device.getSerialNumber();
                    new QueryTask().execute(adress);
                }else{
                    String adress = "http://192.168.0.11:8080/insert/OFF/" + device.getSerialNumber();
                    new QueryTask().execute(adress);
                }
            }
        });
        return view;

    }

    private class QueryTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... adress) {
            try {
                URL url = new URL(adress[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                connection.getResponseCode();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
