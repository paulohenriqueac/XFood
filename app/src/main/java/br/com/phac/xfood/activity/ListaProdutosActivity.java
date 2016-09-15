package br.com.phac.xfood.activity;

import android.os.Bundle;

import br.com.phac.xfood.R;

public class ListaProdutosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        setUpToolbar();
    }
}
