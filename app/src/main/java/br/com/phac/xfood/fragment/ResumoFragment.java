package br.com.phac.xfood.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.phac.xfood.R;

public class ResumoFragment extends Fragment {

    public ResumoFragment() {
        // Required empty public constructor
    }

    public static ResumoFragment novaInstancia() {
        ResumoFragment fragment = new ResumoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumo, container, false);
    }
}
