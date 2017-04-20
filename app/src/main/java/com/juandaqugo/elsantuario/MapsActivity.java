package com.juandaqugo.elsantuario;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String lugar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle extras = getIntent().getExtras();
        lugar = extras.getString("lugar");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        // Add a marker in Sydney and move the camera
        if (lugar.equals("josem") ) {
            LatLng museo = new LatLng(6.139232, -75.266079);
            mMap.addMarker(new MarkerOptions().position(museo).title("Museo José María Córdova").icon(BitmapDescriptorFactory.fromResource(R.drawable.museo)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(museo, 15));
        }else if(lugar.equals("montecristo")){
            LatLng museo = new LatLng(6.139232, -75.266079);
            mMap.addMarker(new MarkerOptions().position(museo).title("Museo Montecristo").icon(BitmapDescriptorFactory.fromResource(R.drawable.museo)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(museo, 15));
        }else if(lugar.equals("ceramica")){
            LatLng ceramica = new LatLng(6.142612, -75.254875);
            mMap.addMarker(new MarkerOptions().position(ceramica).title("La Cerámica").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_ceramica)).snippet("La primera en América Latina"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ceramica, 15));
        }else if(lugar.equals("hotelplaza")){
            LatLng hotel_plaza = new LatLng(6.139854, -75.265319);
            mMap.addMarker(new MarkerOptions().position(hotel_plaza).title("Hotel Plaza").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_hotel)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hotel_plaza, 15));
        }else if(lugar.equals("hotelaraucarias")){
            LatLng hotel_araucarias = new LatLng(6.134949, -75.263653);
            mMap.addMarker(new MarkerOptions().position(hotel_araucarias).title("Hotel las Araucarias").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_hotel)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hotel_araucarias, 15));
        }else if(lugar.equals("hotelruta60")){
            LatLng hotel_ruta60 = new LatLng(6.134535, -75.275350);
            mMap.addMarker(new MarkerOptions().position(hotel_ruta60).title("Hotel Ruta60").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_hotel)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hotel_ruta60, 15));
        }else if(lugar.equals("eros")){
            LatLng eros = new LatLng(6.137789, -75.261388);
            mMap.addMarker(new MarkerOptions().position(eros).title("Erotanatos").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_bar)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eros, 15));
        }else if(lugar.equals("dondo")){
            LatLng dondo = new LatLng(6.138131, -75.261090);
            mMap.addMarker(new MarkerOptions().position(dondo).title("Donde Dondo").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_bar)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dondo, 15));
        }else if(lugar.equals("frontera")){
            LatLng frontera = new LatLng(6.137901, -75.261668);
            mMap.addMarker(new MarkerOptions().position(frontera).title("Donde Dondo").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_bar)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(frontera, 15));
        }else if(lugar.equals("sazon")){
            LatLng sazon = new LatLng(6.137330, -75.280171);
            mMap.addMarker(new MarkerOptions().position(sazon).title("La Sazón del Gordo").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_restaurante)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sazon, 15));
        }else if(lugar.equals("terramonte")){
            LatLng terramonte = new LatLng(6.138526, -75.265635);
            mMap.addMarker(new MarkerOptions().position(terramonte).title("Terramonte").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_restaurante)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terramonte, 15));
        }else if(lugar.equals("restaurante_ruta60")){
            LatLng restaurante_ruta60 = new LatLng(6.134535, -75.275350);
            mMap.addMarker(new MarkerOptions().position(restaurante_ruta60).title("Restaurante Ruta60").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_restaurante)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurante_ruta60, 15));
        }
    }
}
