package br.com.phac.xfood.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.phac.xfood.R;
import br.com.phac.xfood.adapter.ProdutosAdapter;
import br.com.phac.xfood.domain.Produto;
import br.com.phac.xfood.service.ProdutosService;

public class ListaProdutosFragment extends Fragment {
    private static final String TIPO_LISTA = "tipo_lista";
    private String tipo;

    private RecyclerView recyclerView;
    private List<Produto> produtos;

    private ProgressDialog progressDialog;

    public ListaProdutosFragment() {
        // Required empty public constructor
    }

    public static ListaProdutosFragment novaInstancia(String tipoLista) {
        Bundle param = new Bundle();
        param.putString(TIPO_LISTA, tipoLista);

        ListaProdutosFragment fragment = new ListaProdutosFragment();
        fragment.setArguments(param);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.tipo = getArguments().getString(TIPO_LISTA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_lista_produtos, container, false);;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return recyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle b){
        super.onActivityCreated(b);

        new TaskProdutos().execute(this.tipo);
    }

    private class TaskProdutos extends AsyncTask<String, Void, List<Produto>>{

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage(getString(R.string.carregando));
            progressDialog.show();
        }

        @Override
        protected List<Produto> doInBackground(String... strings) {
            List<Produto> prod;

            prod = ProdutosService.getProdutos(tipo);

            return prod;
        }

        @Override
        protected void onPostExecute(List<Produto> produtos) {
            if(produtos != null){
                ListaProdutosFragment.this.produtos = produtos;
                recyclerView.setAdapter(new ProdutosAdapter(getContext(), produtos, onClickProduto()));
            }

            progressDialog.dismiss();
        }
    }

    private ProdutosAdapter.ProdutoOnClickListener onClickProduto(){
        return new ProdutosAdapter.ProdutoOnClickListener() {
            @Override
            public void onClickProduto(View view, int index) {
                Produto produto = produtos.get(index);
                Toast.makeText(getContext(), "Produto " + produto.getNomeProduto() + " adicionado!", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
