package br.com.phac.xfood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.ListaProdutosFragment;

public class ListaProdutosActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        setUpToolbar();

        if (savedInstanceState == null){
            ListaProdutosFragment listaProdutosFragment = ListaProdutosFragment.novaInstancia();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, listaProdutosFragment, "listaProdutos")
                    .commit();
        }
    }
}
