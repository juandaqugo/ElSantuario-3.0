package com.juandaqugo.elsantuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText erusername, erpassword,errpassword,ecorreo;
    Button bregistrese, bcancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        erusername = (EditText) findViewById(R.id.erusername);
        erpassword = (EditText) findViewById(R.id.erpassword);
        errpassword = (EditText) findViewById(R.id.errpassword);
        ecorreo = (EditText) findViewById(R.id.ecorreo);
        bregistrese = (Button) findViewById(R.id.bregistrese);
        bcancelar = (Button) findViewById(R.id.bcancelar);
        bregistrese.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                Intent intent = new Intent();
                if(erusername.getText().toString().equals("") || erpassword.getText().toString().equals("") ||
                errpassword.getText().toString().equals("") || ecorreo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Llene todos los campos",Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED, intent);
                }
                else if(!(erpassword.getText().toString().equals(errpassword.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED, intent);
                }
                else {
                    intent.putExtra("username", erusername.getText().toString());
                    intent.putExtra("contrasena", erpassword.getText().toString());
                    intent.putExtra("correo", ecorreo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }//finaliza la actividad para que no vuelva ahí
            }
        });
        bcancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}
