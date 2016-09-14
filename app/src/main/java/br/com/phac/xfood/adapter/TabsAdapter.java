package br.com.phac.xfood.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.FavoritosFragment;
import br.com.phac.xfood.fragment.ResumoFragment;

public class TabsAdapter extends FragmentPagerAdapter {
    private Context context;

    public TabsAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount(){
        //Quantidade de páginas
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        //Título mostrado nas Tabs
        switch (position){
            case 0:
                return context.getString(R.string.tab_favoritos);
            default:
                return context.getString(R.string.tab_resumo);
        }
    }

    @Override
    public Fragment getItem(int position){
        //Cria o fragment para cada página
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = FavoritosFragment.novaInstancia();
                break;
            default:
                fragment = ResumoFragment.novaInstancia();
        }

        return fragment;
    }
}
