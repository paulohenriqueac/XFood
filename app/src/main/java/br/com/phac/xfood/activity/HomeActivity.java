package br.com.phac.xfood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.phac.xfood.R;
import br.com.phac.xfood.adapter.TabsAdapter;

public class HomeActivity extends BaseActivity {
    private static final String TIPO_LISTA          = "tipo_lista";

    private static final String LISTA_PORCOES       = "lista_porções";
    private static final String LISTA_REFEICOES     = "lista_refeicoes";
    private static final String LISTA_PIZZAS        = "lista_pizzas";
    private static final String LISTA_LANCHES       = "lista_lanches";
    private static final String LISTA_ALCOOLICAS    = "lista_alcoolicas";
    private static final String LISTA_REFRIGERANTES = "lista_refrigerantes";
    private static final String LISTA_SUCOS         = "lista_sucos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpToolbar();
        setupNavDrawer();
        setupViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.menu_sair:
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
                break;
        }

        return true;
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

        // Intent para chamada da tela de lista de produtos
        Intent intent = new Intent(this, ListaProdutosActivity.class);

        //Prepara a intent com a opção selecionada no menu
        switch (menuItem.getItemId()){
            case R.id.menu_porcoes:
                intent.putExtra(TIPO_LISTA, LISTA_PORCOES);
                break;
            case R.id.menu_refeicoes:
                intent.putExtra(TIPO_LISTA, LISTA_REFEICOES);
                break;
            case R.id.menu_pizzas:
                intent.putExtra(TIPO_LISTA, LISTA_PIZZAS);
                break;
            case R.id.menu_lanches:
                intent.putExtra(TIPO_LISTA, LISTA_LANCHES);
                break;
            case R.id.menu_alcoolicas:
                intent.putExtra(TIPO_LISTA, LISTA_ALCOOLICAS);
                break;
            case R.id.menu_refrigerantes:
                intent.putExtra(TIPO_LISTA, LISTA_REFRIGERANTES);
                break;
            case R.id.menu_sucos:
                intent.putExtra(TIPO_LISTA, LISTA_SUCOS);
                break;
        }

        startActivity(intent);
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
