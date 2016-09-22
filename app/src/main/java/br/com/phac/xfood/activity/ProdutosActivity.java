package br.com.phac.xfood.activity;

import android.os.Bundle;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.ProdutosFragment;

public class ProdutosActivity extends BaseActivity {
    private static final String TIPO_LISTA = "tipo_lista";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        setUpToolbar();

        String tipolista = getIntent().getStringExtra(TIPO_LISTA);

        if (savedInstanceState == null){
            ProdutosFragment produtosFragment = ProdutosFragment.novaInstancia(tipolista);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, produtosFragment, "listaProdutos")
                    .commit();
        }
    }
}
