package com.juandaqugo.elsantuario;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ListaActivity extends AppCompatActivity {
    // final String[] nombres_bares = new String[] {"Erotanatos", "DondeDondo", "Frontera"};
    Intent intent;
    String username, correo;
    private Lista_Entrada [] datos_bares= new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.icono_sazon, "La Sazon del Gordo", "Autopista"),
            new Lista_Entrada(R.drawable.icono_terramonte, "Terramonte", "Parque Principal "),
            new Lista_Entrada(R.drawable.icono_restauranteruta60, "Restaurante Ruta 60", "Salida a Medellin ")};
    ListView list_restaurantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");
        list_restaurantes = (ListView) findViewById(R.id.list_restaurantes);
        Adapter adapter = new Adapter(this, datos_bares);
        list_restaurantes.setAdapter(adapter);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);


        list_restaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ( (Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
               // Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0 :  intent = new Intent(ListaActivity.this, Restaurante1Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    case 1 :  intent = new Intent(ListaActivity.this, Restaurante2Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    case 2 :   intent = new Intent(ListaActivity.this, Restaurante3Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                }
            }

        });
    }
    class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter(Context context, Lista_Entrada[] datos_bares) {
            super(context, R.layout.list_item,datos_bares);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item,null);

            TextView nombre= (TextView) item.findViewById(R.id.t_lista_restaurantes_Nombre);
            nombre.setText(datos_bares[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.t_lista_restaurantes_descrip);
            descrip.setText(datos_bares[position].getDescrip());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos_bares[position].getIdImagen());
            return item;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.atraslista:
                intent = new Intent(ListaActivity.this, DrawerMainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

