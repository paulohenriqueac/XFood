package br.com.phac.xfood.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.phac.xfood.R;

public class BaseActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    protected void setUpToolbar() {
        // Configurar a Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Icone hamburguer na Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
