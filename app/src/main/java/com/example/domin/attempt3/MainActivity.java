package com.example.domin.attempt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eegeo.mapapi.EegeoApi;
import com.eegeo.mapapi.EegeoMap;
import com.eegeo.mapapi.MapView;
import com.eegeo.mapapi.map.OnMapReadyCallback;
import com.eegeo.mapapi.markers.Marker;
import com.eegeo.mapapi.markers.MarkerOptions;
import com.eegeo.mapapi.map.OnInitialStreamingCompleteListener;

import com.eegeo.mapapi.camera.CameraPosition;
import com.eegeo.mapapi.camera.CameraUpdateFactory;

public class MainActivity extends AppCompatActivity {

    private MapView m_mapView;
    private EegeoMap m_eegeoMap = null;
    private Marker m_marker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Seting up API key

        EegeoApi.init(this, "53f4c834b8971f09274f49d43fa3f85c"); //Initilises the API with the key

        setContentView(R.layout.activity_main);

        m_mapView = (MapView)findViewById(R.id.mapView);
        m_mapView.onCreate(savedInstanceState);

        m_mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final EegeoMap  map)
            {
                Toast.makeText(MainActivity.this, "Welcome to Eego Maps", Toast.LENGTH_LONG).show();
            }


        });
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        m_mapView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        m_mapView.onPause();

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        m_mapView.onDestroy();
    }
}
