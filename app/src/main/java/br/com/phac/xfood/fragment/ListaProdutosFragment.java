package br.com.phac.xfood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.phac.xfood.R;

public class ListaProdutosFragment extends Fragment {
    private static final String TIPO_LISTA = "tipo_lista";

    public ListaProdutosFragment() {
        // Required empty public constructor
    }

    public static ListaProdutosFragment novaInstancia() {
        ListaProdutosFragment fragment = new ListaProdutosFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_produtos, container, false);

        Intent intent = getActivity().getIntent();

        TextView txtTipoLista = (TextView) view.findViewById(R.id.txtListaProdutos);

        txtTipoLista.setText(intent.getStringExtra(TIPO_LISTA));

        return view;
    }
}
