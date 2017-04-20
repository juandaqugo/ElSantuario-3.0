package com.juandaqugo.elsantuario;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment2Fragment extends Fragment {
    Button bmapa;
    Intent intent;
    String lugar = "dondo";


    public fragment2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
        bmapa = (Button) rootView.findViewById(R.id.Bdondo);
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
