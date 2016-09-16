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
    private String tipo;

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
        View view = inflater.inflate(R.layout.fragment_lista_produtos, container, false);

        TextView txtTipoLista = (TextView) view.findViewById(R.id.txtListaProdutos);
        txtTipoLista.setText(this.tipo);

        return view;
    }
}
