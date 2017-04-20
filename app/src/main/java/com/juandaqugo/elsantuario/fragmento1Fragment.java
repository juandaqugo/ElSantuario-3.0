package com.juandaqugo.elsantuario;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.fitness.data.MapValue;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmento1Fragment extends Fragment {
    Button bmapa;
    Intent intent;
    String lugar = "eros";
    public fragmento1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragmento1, container, false);
        View rootView = inflater.inflate(R.layout.fragment_fragmento1,container,false);
        bmapa = (Button) rootView.findViewById(R.id.Beros);
        bmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(),MapsActivity.class);
                intent.putExtra("lugar", lugar);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
