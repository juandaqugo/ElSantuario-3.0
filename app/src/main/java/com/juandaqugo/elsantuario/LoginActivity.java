package com.juandaqugo.elsantuario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    EditText eusername, epassword;
    Button biniciar;
    TextView tregistrarse;
    String username, password, correo;
    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        password = extras.getString("contrasena");
        correo = extras.getString("correo");*/
        prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor = prefs.edit();

        username = prefs.getString("username", "noname");
        password =prefs.getString("contrasena", "nopass");
        correo = prefs.getString("correo", "nocorreo");

        if(prefs.getInt("login", -1) == 1) {
            intent = new Intent(LoginActivity.this, DrawerMainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }

        eusername = (EditText) findViewById(R.id.eusername);
        epassword = (EditText) findViewById(R.id.epassword);
        tregistrarse = ( TextView ) findViewById(R.id.tregistrarse);
        biniciar = (Button) findViewById(R.id.biniciar);
        tregistrarse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this ,RegistroActivity.class);
                startActivityForResult(intent, 1234);
            }
        });
        biniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(eusername.getText().toString().equals("") || epassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Llene los campos requeridos",Toast.LENGTH_SHORT).show();
                }
                else if(!(eusername.getText().toString().equals(username) && epassword.getText().toString().equals(password))){
                    Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
                }
                else if(eusername.getText().toString().equals(username) && epassword.getText().toString().equals(password)){
                    editor.putInt("login",1);
                    editor.commit();

                    intent = new Intent(LoginActivity.this, DrawerMainActivity.class);
                    intent.putExtra("username", username); //mando de loginActivity a mainActivity
                    intent.putExtra("correo", correo);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("contrasena");
            correo = data.getExtras().getString("correo");
            editor.putString("username", username);
            editor.putString("contrasena", password);
            editor.putString("correo", correo);

            Log.d("username", username); //verifica por consola cual es el valor que manda
        }else{
            if(requestCode==1234 && resultCode==RESULT_CANCELED){
                Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
