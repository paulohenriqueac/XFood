package br.com.phac.xfood.activity;

import android.os.Bundle;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.ListaProdutosFragment;

public class ListaProdutosActivity extends BaseActivity {
    private static final String TIPO_LISTA = "tipo_lista";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        setUpToolbar();

        String tipolista = getIntent().getStringExtra(TIPO_LISTA);

        if (savedInstanceState == null){
            ListaProdutosFragment listaProdutosFragment = ListaProdutosFragment.novaInstancia(tipolista);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, listaProdutosFragment, "listaProdutos")
                    .commit();
        }
    }
}
