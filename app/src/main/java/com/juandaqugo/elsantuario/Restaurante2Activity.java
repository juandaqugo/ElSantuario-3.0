package com.juandaqugo.elsantuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Restaurante2Activity extends AppCompatActivity {
    String username, correo;
        Button bmapa;
        Intent intent;
        String lugar = "terramonte";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante2);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");
        bmapa = (Button) findViewById(R.id.Bterramonte);
        bmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Restaurante2Activity.this ,MapsActivity.class);
                intent.putExtra("lugar", lugar);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menurestaurante2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.atras2:
                intent = new Intent(Restaurante2Activity.this, ListaActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
