package br.com.phac.xfood.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.ProdutosFragment;

public class QuantidadeDialog extends DialogFragment {
    TextView textViewQtde;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_quantidade, container, false);

        getDialog().setTitle(R.string.quantidade);

        textViewQtde = (TextView) view.findViewById(R.id.textViewQtde);

        Button btnMenos = (Button) view.findViewById(R.id.buttonMenos);
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int qtde = Integer.parseInt(textViewQtde.getText().toString());

                if (qtde != 1) {
                    String valor = String.valueOf(qtde - 1);
                    qtde = Integer.valueOf(valor);

                    DecimalFormat f = new DecimalFormat("00");
                    String format = f.format(qtde);

                    textViewQtde.setText(format);
                }
            }
        });

        Button btnMais = (Button) view.findViewById(R.id.buttonMais);
        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qtde = Integer.parseInt(textViewQtde.getText().toString());

                if (qtde != 99) {
                    String valor = String.valueOf(qtde + 1);
                    qtde = Integer.valueOf(valor);

                    DecimalFormat f = new DecimalFormat("00");
                    String format = f.format(qtde);

                    textViewQtde.setText(format);
                }
            }
        });

        Button btnCancelar = (Button) view.findViewById(R.id.buttonCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button btnConfirmar = (Button) view.findViewById(R.id.buttonConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ProdutosFragment.RESULT_QTDE, textViewQtde.getText().toString());

                Intent intent = new Intent().putExtras(bundle);

                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);

                dismiss();
            }
        });

        return view;
    }
}
