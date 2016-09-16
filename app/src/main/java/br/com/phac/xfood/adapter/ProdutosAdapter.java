package br.com.phac.xfood.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.phac.xfood.R;

public class ProdutosAdapter {

    public static class ProdutosViewHolder extends RecyclerView.ViewHolder{
        TextView    nomeProd;
        ImageView   imagemProd;
        ProgressBar progressBar;
        TextView    descricaoProd;
        CardView    cardView;

        public ProdutosViewHolder(View view){
            super(view);
            nomeProd      = (TextView) view.findViewById(R.id.nomeProduto);
            imagemProd    = (ImageView) view.findViewById(R.id.imagemProduto);
            progressBar   = (ProgressBar) view.findViewById(R.id.progressBar);
            descricaoProd = (TextView) view.findViewById(R.id.descricaoProduto);
            cardView      = (CardView) view.findViewById(R.id.card_view);

        }
    }
}
