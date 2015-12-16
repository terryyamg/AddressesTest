package com.terryyamg.addressestest;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvAddress = (TextView) findViewById(R.id.tvAddress);

        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = null;
        double lat = 22.6721740;
        double lon = 120.3100350;
        try {
            addresses = geocoder.getFromLocation(lat, lon, 1); //放入座標
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses != null && addresses.size() > 0) {
            Address address = addresses.get(0);
            String addressText = String.format("%s-%s%s%s%s",
                    address.getCountryName(), //國家
                    address.getAdminArea(), //城市
                    address.getLocality(), //區
                    address.getThoroughfare(), //路
                    address.getSubThoroughfare() //巷號
            );

            tvAddress.setText(addressText);
        }

    }

}
