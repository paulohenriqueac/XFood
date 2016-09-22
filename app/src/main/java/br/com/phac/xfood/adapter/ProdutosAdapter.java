package br.com.phac.xfood.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import br.com.phac.xfood.R;
import br.com.phac.xfood.domain.Produto;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>{

    private final Context context;
    private final List<Produto> produtos;
    private ProdutoOnClickListener produtoOnClickListener;

    public ProdutosAdapter(Context context, List<Produto> produtos, ProdutoOnClickListener produtoOnClickListener) {
        this.context = context;
        this.produtos = produtos;
        this.produtoOnClickListener = produtoOnClickListener;
    }

    @Override
    public ProdutosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.adapter_produtos, parent, false);
        ProdutosViewHolder holder = new ProdutosViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ProdutosViewHolder holder, final int position) {
        Produto prod = this.produtos.get(position);

        holder.nomeProd.setText(prod.getNomeProduto());

        DecimalFormat f = new DecimalFormat("##0.00");
        holder.valorProd.setText(f.format(prod.getValorProduto()));

        Picasso.with(this.context).load(prod.getImagemProduto()).error(R.drawable.plate).fit().into(holder.imagemProd, null);
        holder.descricaoProd.setText(prod.getDescricaoProduto());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                produtoOnClickListener.onClickProduto(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.produtos != null? this.produtos.size(): 0;
    }

    public static class ProdutosViewHolder extends RecyclerView.ViewHolder{
        TextView nomeProd;
        TextView valorProd;
        ImageView imagemProd;
        TextView descricaoProd;
        CardView cardView;

        public ProdutosViewHolder(View view){
            super(view);

            nomeProd = (TextView) view.findViewById(R.id.nomeProduto);
            valorProd = (TextView) view.findViewById(R.id.valorProduto);
            imagemProd = (ImageView) view.findViewById(R.id.imagemProduto);
            descricaoProd = (TextView) view.findViewById(R.id.descricaoProduto);
            cardView = (CardView) view.findViewById(R.id.cardViewProduto);
        }
    }

    public interface ProdutoOnClickListener{
        public void onClickProduto(View view, int index);
    }
}
