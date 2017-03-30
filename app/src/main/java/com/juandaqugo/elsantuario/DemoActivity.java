package com.juandaqugo.elsantuario;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ElSantuario1Fragment fragment = new ElSantuario1Fragment();
        ft.add(android.R.id.content, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch(id) {
            case R.id.mfragment1:
                ElSantuario1Fragment frag = new ElSantuario1Fragment();
                ft.replace(android.R.id.content, frag).commit();
                break;
            case R.id.mfragment2 :
                ElSantuario2Fragment frag2 = new ElSantuario2Fragment();
                ft.replace(android.R.id.content, frag2).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
