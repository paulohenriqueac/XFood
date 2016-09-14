package br.com.phac.xfood.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.phac.xfood.R;
import br.com.phac.xfood.adapter.TabsAdapter;

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

    //Configurar o Navigation Drawer
    protected void setupNavDrawer(){
        //Icone hamburguer na Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        selecionarOpcaoMenu(menuItem);
                        return true;
                    }
                }
        );
    }

    private void selecionarOpcaoMenu(MenuItem menuItem) {
        // Seleciona o item de menu clicado
        menuItem.setChecked(true);

        //switch (menuItem.getItemId()){
        //    case R.id.menu_sair:
        //        finish();
        //        break;
        //}

        //Fecha o menu
        drawerLayout.closeDrawers();
    }

    public void setupViewPager(){
        //ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new TabsAdapter(getBaseContext(), getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
