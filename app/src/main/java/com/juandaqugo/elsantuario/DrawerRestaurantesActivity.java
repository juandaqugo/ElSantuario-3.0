package com.juandaqugo.elsantuario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DrawerRestaurantesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;
    private Lista_Entrada[] datos_restaurantes = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.eros, "Erotanatos", "Parque la Judea"),
            new Lista_Entrada(R.drawable.dondedondo, "Donde Dondo", "Parque la Judea "),
            new Lista_Entrada(R.drawable.frontera, "Frontera Discoteca", "Parque la Judea ")};
    ListView list_restaurantes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_restaurantes1 = (ListView) findViewById(R.id.list_restaurantes1);
       // Adapter adapter = new Adapter(this, datos_restaurantes);
       // list_restaurantes1.setAdapter(adapter);
        list_restaurantes1.setAdapter(new Adapter(this,datos_restaurantes));

        setContentView(R.layout.activity_drawer_restaurantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      /*  list_restaurantes1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ( (Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0 :   //FragmentManager fm = getSupportFragmentManager();
                       // FragmentTransaction ft = fm.beginTransaction();

                       // fragmento1Fragment fragment =  new fragmento1Fragment();
                       // ft.replace(R.id.container2, fragment).commit();
                        break;
                    case 1 : //  FragmentManager fm1 = getSupportFragmentManager();
                        //   FragmentTransaction ft1 = fm1.beginTransaction();

                        // fragmento1Fragment fragment1 =  new fragmento1Fragment();
                        //  ft1.replace(R.id.contenedor2, fragment1).commit();
                        break;
                    case 2 :
                        break;
                }
            }

        });*/
    }

    class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos_restaurantes) {
            super(context, R.layout.list_item, datos_restaurantes);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.t_lista_restaurantes_Nombre);
            nombre.setText(datos_restaurantes[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.t_lista_restaurantes_descrip);
            descrip.setText(datos_restaurantes[position].getDescrip());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos_restaurantes[position].getIdImagen());
            return item;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_restaurantes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
